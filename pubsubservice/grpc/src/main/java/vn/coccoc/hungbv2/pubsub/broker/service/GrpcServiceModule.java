package vn.coccoc.hungbv2.pubsub.broker.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.coccoc.hungbv2.pubsub.broker.core.ServiceContext;

@Configuration
public class GrpcServiceModule {

  @Bean
  public GrpcPubSubServices grpcPubSubServices(ServiceContext serviceContext) {
    return new GrpcPubSubServices(serviceContext);
  }
}