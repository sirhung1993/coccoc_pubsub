package vn.coccoc.hungbv2.pubsub.broker.base;

import io.grpc.BindableService;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public abstract class AbstractGrpcBeanConfigure {

  @Autowired
  protected ApplicationContext applicationContext;
  @Value("${pubsub.grpc.port}")
  private String grpcPort;

  @Bean
  public GrpcServer grpcServer(ApplicationContext applicationContext) {
    ServerBuilder<?> serverBuilder = ServerBuilder.forPort(Integer.valueOf(grpcPort));
    for (BindableService bindableService : getGrpcRegister().serviceRegister()) {
      serverBuilder.addService(bindableService);
    }
    GrpcServer grpcServer = new GrpcServer(serverBuilder.build());
    grpcServer.start();
    return grpcServer;
  }

  protected abstract AbstractGrpcRegister getGrpcRegister();

}