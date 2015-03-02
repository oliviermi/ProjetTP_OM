package org.ili.java.projecttp.utils.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

@Component
public class LoggableInjector implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {

    ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {

      public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {

        // make the field accessible if defined private

        ReflectionUtils.makeAccessible(field);
        if (field.getAnnotation(Loggable.class) != null && field.getType().equals(Logger.class)) {
          final Logger log = LoggerFactory.getLogger(bean.getClass());
          field.set(bean, log);
        }
      }
    });
    return bean;
  }

  public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
    return bean;
  }

}
