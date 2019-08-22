package vn.coccoc.hungbv2.pubsub.client.core;

import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;

public interface ClientGrpcInterface {
  GrpcPubSubServiceBlockingStub getStub(String host, Integer port);
}
