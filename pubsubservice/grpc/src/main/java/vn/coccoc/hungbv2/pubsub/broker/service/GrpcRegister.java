package vn.coccoc.hungbv2.pubsub.broker.service;

import io.grpc.BindableService;
import java.util.Collection;
import org.springframework.context.ApplicationContext;
import vn.coccoc.hungbv2.pubsub.broker.base.AbstractGrpcRegister;

public class GrpcRegister extends AbstractGrpcRegister {

  public GrpcRegister(ApplicationContext applicationContext) {
    super(applicationContext);
  }

  public Collection<BindableService> serviceRegister() {
    return applicationContext.getBeansOfType(BindableService.class).values();
  }

}