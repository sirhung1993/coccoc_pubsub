package vn.coccoc.hungbv2.pubsub.broker.service;

import io.grpc.stub.StreamObserver;
import vn.coccoc.hungbv2.pubsub.broker.base.ExceptionHandler;
import vn.coccoc.pubsub.model.PubSubModel.CommonResponse;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceImplBase;

public class GrpcPubSubServices extends GrpcPubSubServiceImplBase {

  @Override
  public void subcribe(SubcribeContent request, StreamObserver<CommonResponse> responseObserver) {
    try {
      String host = request.getHostGrpc();
      String port = request.getPortGrpc();
      responseObserver.onNext(CommonResponse.newBuilder()
          .setStatusCode(200)
          .setMessage("OK")
          .build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      ExceptionHandler.handle(responseObserver, e);
    }
  }
}
