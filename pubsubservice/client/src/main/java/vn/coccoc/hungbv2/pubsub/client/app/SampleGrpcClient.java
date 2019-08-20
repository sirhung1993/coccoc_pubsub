package vn.coccoc.hungbv2.pubsub.client.app;

import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.pubsub.model.PubSubModel.CommonResponse;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;

public class SampleGrpcClient {

  public static void main(String[] args) {
    String grpcHost = "localhost";
    Integer grpcPort = 2180;

    GrpcClient grpcClient = new GrpcClient(grpcHost, grpcPort, null);
    GrpcServiceStubFactory stubFactory = new GrpcServiceStubFactory(grpcClient);

    GrpcPubSubServiceBlockingStub stub = stubFactory.getBlockingStubService(GrpcPubSubServiceGrpc.class,
        GrpcPubSubServiceBlockingStub.class);
    CommonResponse res = stub.subcribe(SubcribeContent.newBuilder()
        .setHostGrpc(grpcHost)
        .setPortGrpc(grpcPort.toString())
        .setTopicName("hello")
        .build());
    System.out.println(res);
  }
}
