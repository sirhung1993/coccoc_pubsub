package vn.coccoc.hungbv2.pubsub.broker.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceContextImpl implements ServiceContext {

  private final ApplicationContext applicationContext;

  @Autowired
  public ServiceContextImpl(ApplicationContext applicationContext) {
    if (applicationContext == null) {
      throw new IllegalArgumentException("null applicationContext");
    }

    this.applicationContext = applicationContext;

  }

  @Override
  public <T> T getInstance(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

}
