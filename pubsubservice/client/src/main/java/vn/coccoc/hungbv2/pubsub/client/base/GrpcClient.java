package vn.coccoc.hungbv2.pubsub.client.base;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
  private final ManagedChannel channel;

  public GrpcClient(String grpcHost, int grpcPort, Map<String, String> additionalHeaders) {
    channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort).usePlaintext().build();
  }

  public ManagedChannel getManagedChannel() {
    return channel;
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(15, TimeUnit.SECONDS);
  }
}
