package vn.coccoc.hungbv2.pubsub.client.base;

import io.grpc.Channel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.AbstractStub;
import java.lang.reflect.Method;

public class GrpcServiceStubFactory {
  private final GrpcClient grpcClient;

  public GrpcServiceStubFactory(GrpcClient grpcClient) {
    this.grpcClient = grpcClient;
  }

  @SuppressWarnings("unchecked")
  public <S, BS extends AbstractStub<BS>> BS getBlockingStubService(Class<S> grpcService,
      Class<BS> grpcBlockingStub) {
    try {
      Method blockingStubMethod = grpcService.getMethod("newBlockingStub", Channel.class);
      BS bs = (BS) blockingStubMethod.invoke(null, grpcClient.getManagedChannel());
      return bs;
    } catch (Exception e) {
      throw new StatusRuntimeException(Status.INTERNAL.withDescription(e.getMessage()));
    }
  }
}
