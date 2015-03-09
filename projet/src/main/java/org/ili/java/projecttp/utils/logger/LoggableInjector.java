package org.ili.java.projecttp.utils.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * @author Olivier MICHALSKI
 *
 */
@Component
public class LoggableInjector implements BeanPostProcessor {

  /* (non-Javadoc)
   * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
   */
  public Object postProcessBeforeInitialization(final Object bean, final String beanName) {

    ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {

      public void doWith(final Field field) throws IllegalAccessException {

        // make the field accessible if defined private
        ReflectionUtils.makeAccessible(field);
        if (field.getAnnotation(Loggable.class) != null && field.getType().equals(Logger.class)) {
          final Logger myLogger = LoggerFactory.getLogger(bean.getClass());
          field.set(bean, myLogger);
        }
      }
    });
    return bean;
  }

  /* (non-Javadoc)
   * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
   */
  public Object postProcessAfterInitialization(final Object bean, final String beanName) {
    return bean;
  }
}
