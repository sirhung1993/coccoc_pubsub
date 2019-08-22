package vn.coccoc.hungbv2.pubsub.client.core;

import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;

public abstract class AbstractClient {

  protected final String grpcBrokerHost;
  protected final Integer grpcBrokerPort;

  public AbstractClient(String host, Integer port) {
    this.grpcBrokerHost = host;
    this.grpcBrokerPort = port;
  }
}
