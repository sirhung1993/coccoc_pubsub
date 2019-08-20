package vn.coccoc.hungbv2.pubsub.broker.base;

import io.grpc.BindableService;
import io.grpc.ServerInterceptor;
import java.util.Collection;
import org.springframework.context.ApplicationContext;

public abstract class AbstractGrpcRegister {

  protected final ApplicationContext applicationContext;

  public AbstractGrpcRegister(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public abstract Collection<BindableService> serviceRegister();
  
}
