package vn.coccoc.hungbv2.pubsub.broker.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.coccoc.hungbv2.pubsub.broker.controller.impl.BrokerControllerImpl;
import vn.coccoc.hungbv2.pubsub.broker.core.ServiceContext;

@Configuration
public class BrokerModule {

  @Bean
  public BrokerController brokerController(ServiceContext serviceContext) {
    return new BrokerControllerImpl(serviceContext);
  }
}
