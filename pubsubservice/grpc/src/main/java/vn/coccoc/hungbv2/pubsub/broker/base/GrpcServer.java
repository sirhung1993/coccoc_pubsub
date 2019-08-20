package vn.coccoc.hungbv2.pubsub.broker.base;

import io.grpc.Server;
import java.io.IOException;
import javax.annotation.PreDestroy;

public class GrpcServer extends Thread {

  private final Server server;

  public GrpcServer(Server server) {
    this.server = server;
  }

  public void stopServer() {
    if (server != null) {
      server.shutdown();
    }
  }

  @Override
  public void run() {
    startServer();
  }

  @PreDestroy
  public void onDestroy() {
    stopServer();
    System.out.println("Grpc server is stopping");
  }

  private void startServer() {
    try {
      server.start();
      server.awaitTermination();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
