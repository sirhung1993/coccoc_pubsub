package vn.coccoc.hungbv2.pubsub.broker.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreModule {

  @Bean
  public ServiceContext serviceContext(ApplicationContext applicationContext) {
    return new ServiceContextImpl(applicationContext);
  }
}
