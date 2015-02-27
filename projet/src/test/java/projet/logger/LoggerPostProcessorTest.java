package projet.logger;


import junit.framework.Assert;

import org.ili.java.projecttp.utils.logger.Loggable;
import org.ili.java.projecttp.utils.logger.LoggableInjector;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;



public class LoggerPostProcessorTest {

  DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

  @Before
  public void setupFactory() {
    @SuppressWarnings("deprecation")
	final RootBeanDefinition bean = new RootBeanDefinition(Bean.class, true);
    factory.addBeanPostProcessor(new LoggableInjector());
    factory.registerBeanDefinition("bean", bean);
  }

  @Test
  public void injectLogger() {
    final Bean b = (Bean) factory.getBean("bean");
    Assert.assertNotNull(b.log);
    b.doSomething();
  }
}

class Bean {

  @Loggable 
  Logger log;

  public void doSomething() {
    log.debug("message");
  }
}
