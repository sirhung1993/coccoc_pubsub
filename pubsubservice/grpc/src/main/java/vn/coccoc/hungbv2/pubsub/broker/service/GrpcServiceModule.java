package vn.coccoc.hungbv2.pubsub.broker.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServiceModule {

  @Bean
  public GrpcPubSubServices grpcPubSubServices() {
    return new GrpcPubSubServices();
  }
}