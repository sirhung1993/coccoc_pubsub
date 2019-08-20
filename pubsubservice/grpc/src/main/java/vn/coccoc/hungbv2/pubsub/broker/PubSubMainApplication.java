package vn.coccoc.hungbv2.pubsub.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import vn.coccoc.hungbv2.pubsub.broker.service.GrpcServiceModule;

@SpringBootApplication
@Import({GrpcServiceModule.class})
public class PubSubMainApplication {
  public static void main(String[] args) {
    SpringApplication.run(PubSubMainApplication.class, args);
  }
}
