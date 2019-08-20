package vn.coccoc.hungbv2.pubsub.broker.service;

import org.springframework.context.annotation.Configuration;
import vn.coccoc.hungbv2.pubsub.broker.base.AbstractGrpcBeanConfigure;
import vn.coccoc.hungbv2.pubsub.broker.base.AbstractGrpcRegister;

@Configuration
public class GrpcBeanConfigure extends AbstractGrpcBeanConfigure {

  @Override
  protected AbstractGrpcRegister getGrpcRegister() {
    return new GrpcRegister(applicationContext);
  }

}