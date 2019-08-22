package vn.coccoc.hungbv2.pubsub.broker.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import vn.coccoc.hungbv2.pubsub.broker.base.ExceptionHandler;
import vn.coccoc.hungbv2.pubsub.broker.controller.BrokerController;
import vn.coccoc.hungbv2.pubsub.broker.core.ServiceContext;
import vn.coccoc.pubsub.model.PubSubModel.CommonRequest;
import vn.coccoc.pubsub.model.PubSubModel.CommonResponse;
import vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.PubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceImplBase;

public class GrpcPubSubServices extends GrpcPubSubServiceImplBase {

  private final ServiceContext serviceContext;
  private final BrokerController brokerController;

  public GrpcPubSubServices(ServiceContext serviceContext) {
   this.serviceContext = serviceContext;
   this.brokerController = serviceContext.getInstance(BrokerController.class);
  }

  @Override
  public void subcribe(SubcribeContent request, StreamObserver<CommonResponse> responseObserver) {
    try {
      responseObserver.onNext(brokerController.subscribe(request));
      responseObserver.onCompleted();
    } catch (Exception e) {
      ExceptionHandler.handle(responseObserver, e);
    }
  }

  @Override
  public void unsubcribe(SubcribeContent request, StreamObserver<CommonResponse> responseObserver) {
    try {
      responseObserver.onNext(brokerController.unsubscribe(request));
      responseObserver.onCompleted();
    } catch (Exception e) {
      ExceptionHandler.handle(responseObserver, e);
    }
  }

  @Override
  public void pubMessage(PubSubMessage request, StreamObserver<CommonResponse> responseObserver) {
    try {
      responseObserver.onNext(brokerController.pubMessage(request));
      responseObserver.onCompleted();
    } catch (Exception e) {
      ExceptionHandler.handle(responseObserver, e);
    }
  }

  @Override
  public void subMessage(CommonRequest request, StreamObserver<ListPubSubMessage> responseObserver) {
    try {
      responseObserver.onNext(brokerController.subMessage(request));
      responseObserver.onCompleted();
    } catch (Exception e) {
      ExceptionHandler.handle(responseObserver, e);
    }
  }
}
