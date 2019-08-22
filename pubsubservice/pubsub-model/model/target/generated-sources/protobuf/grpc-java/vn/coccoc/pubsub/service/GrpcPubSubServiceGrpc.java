package vn.coccoc.pubsub.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: PubSubService.proto")
public final class GrpcPubSubServiceGrpc {

  private GrpcPubSubServiceGrpc() {}

  public static final String SERVICE_NAME = "vn.coccoc.pubsub.service.GrpcPubSubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getSubcribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subcribe",
      requestType = vn.coccoc.pubsub.model.PubSubModel.SubcribeContent.class,
      responseType = vn.coccoc.pubsub.model.PubSubModel.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getSubcribeMethod() {
    io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent, vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getSubcribeMethod;
    if ((getSubcribeMethod = GrpcPubSubServiceGrpc.getSubcribeMethod) == null) {
      synchronized (GrpcPubSubServiceGrpc.class) {
        if ((getSubcribeMethod = GrpcPubSubServiceGrpc.getSubcribeMethod) == null) {
          GrpcPubSubServiceGrpc.getSubcribeMethod = getSubcribeMethod = 
              io.grpc.MethodDescriptor.<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent, vn.coccoc.pubsub.model.PubSubModel.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.coccoc.pubsub.service.GrpcPubSubService", "subcribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.SubcribeContent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.CommonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcPubSubServiceMethodDescriptorSupplier("subcribe"))
                  .build();
          }
        }
     }
     return getSubcribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getUnsubcribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unsubcribe",
      requestType = vn.coccoc.pubsub.model.PubSubModel.SubcribeContent.class,
      responseType = vn.coccoc.pubsub.model.PubSubModel.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getUnsubcribeMethod() {
    io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent, vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getUnsubcribeMethod;
    if ((getUnsubcribeMethod = GrpcPubSubServiceGrpc.getUnsubcribeMethod) == null) {
      synchronized (GrpcPubSubServiceGrpc.class) {
        if ((getUnsubcribeMethod = GrpcPubSubServiceGrpc.getUnsubcribeMethod) == null) {
          GrpcPubSubServiceGrpc.getUnsubcribeMethod = getUnsubcribeMethod = 
              io.grpc.MethodDescriptor.<vn.coccoc.pubsub.model.PubSubModel.SubcribeContent, vn.coccoc.pubsub.model.PubSubModel.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.coccoc.pubsub.service.GrpcPubSubService", "unsubcribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.SubcribeContent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.CommonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcPubSubServiceMethodDescriptorSupplier("unsubcribe"))
                  .build();
          }
        }
     }
     return getUnsubcribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.PubSubMessage,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getPubMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pubMessage",
      requestType = vn.coccoc.pubsub.model.PubSubModel.PubSubMessage.class,
      responseType = vn.coccoc.pubsub.model.PubSubModel.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.PubSubMessage,
      vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getPubMessageMethod() {
    io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.PubSubMessage, vn.coccoc.pubsub.model.PubSubModel.CommonResponse> getPubMessageMethod;
    if ((getPubMessageMethod = GrpcPubSubServiceGrpc.getPubMessageMethod) == null) {
      synchronized (GrpcPubSubServiceGrpc.class) {
        if ((getPubMessageMethod = GrpcPubSubServiceGrpc.getPubMessageMethod) == null) {
          GrpcPubSubServiceGrpc.getPubMessageMethod = getPubMessageMethod = 
              io.grpc.MethodDescriptor.<vn.coccoc.pubsub.model.PubSubModel.PubSubMessage, vn.coccoc.pubsub.model.PubSubModel.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.coccoc.pubsub.service.GrpcPubSubService", "pubMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.PubSubMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.CommonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcPubSubServiceMethodDescriptorSupplier("pubMessage"))
                  .build();
          }
        }
     }
     return getPubMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.CommonRequest,
      vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> getSubMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subMessage",
      requestType = vn.coccoc.pubsub.model.PubSubModel.CommonRequest.class,
      responseType = vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.CommonRequest,
      vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> getSubMessageMethod() {
    io.grpc.MethodDescriptor<vn.coccoc.pubsub.model.PubSubModel.CommonRequest, vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> getSubMessageMethod;
    if ((getSubMessageMethod = GrpcPubSubServiceGrpc.getSubMessageMethod) == null) {
      synchronized (GrpcPubSubServiceGrpc.class) {
        if ((getSubMessageMethod = GrpcPubSubServiceGrpc.getSubMessageMethod) == null) {
          GrpcPubSubServiceGrpc.getSubMessageMethod = getSubMessageMethod = 
              io.grpc.MethodDescriptor.<vn.coccoc.pubsub.model.PubSubModel.CommonRequest, vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vn.coccoc.pubsub.service.GrpcPubSubService", "subMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.CommonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcPubSubServiceMethodDescriptorSupplier("subMessage"))
                  .build();
          }
        }
     }
     return getSubMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcPubSubServiceStub newStub(io.grpc.Channel channel) {
    return new GrpcPubSubServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcPubSubServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcPubSubServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcPubSubServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcPubSubServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GrpcPubSubServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void subcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubcribeMethod(), responseObserver);
    }

    /**
     */
    public void unsubcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnsubcribeMethod(), responseObserver);
    }

    /**
     */
    public void pubMessage(vn.coccoc.pubsub.model.PubSubModel.PubSubMessage request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPubMessageMethod(), responseObserver);
    }

    /**
     */
    public void subMessage(vn.coccoc.pubsub.model.PubSubModel.CommonRequest request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSubMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubcribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
                vn.coccoc.pubsub.model.PubSubModel.CommonResponse>(
                  this, METHODID_SUBCRIBE)))
          .addMethod(
            getUnsubcribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vn.coccoc.pubsub.model.PubSubModel.SubcribeContent,
                vn.coccoc.pubsub.model.PubSubModel.CommonResponse>(
                  this, METHODID_UNSUBCRIBE)))
          .addMethod(
            getPubMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vn.coccoc.pubsub.model.PubSubModel.PubSubMessage,
                vn.coccoc.pubsub.model.PubSubModel.CommonResponse>(
                  this, METHODID_PUB_MESSAGE)))
          .addMethod(
            getSubMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vn.coccoc.pubsub.model.PubSubModel.CommonRequest,
                vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage>(
                  this, METHODID_SUB_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcPubSubServiceStub extends io.grpc.stub.AbstractStub<GrpcPubSubServiceStub> {
    private GrpcPubSubServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcPubSubServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPubSubServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcPubSubServiceStub(channel, callOptions);
    }

    /**
     */
    public void subcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubcribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnsubcribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pubMessage(vn.coccoc.pubsub.model.PubSubModel.PubSubMessage request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPubMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subMessage(vn.coccoc.pubsub.model.PubSubModel.CommonRequest request,
        io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcPubSubServiceBlockingStub extends io.grpc.stub.AbstractStub<GrpcPubSubServiceBlockingStub> {
    private GrpcPubSubServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcPubSubServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPubSubServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcPubSubServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public vn.coccoc.pubsub.model.PubSubModel.CommonResponse subcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request) {
      return blockingUnaryCall(
          getChannel(), getSubcribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public vn.coccoc.pubsub.model.PubSubModel.CommonResponse unsubcribe(vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request) {
      return blockingUnaryCall(
          getChannel(), getUnsubcribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public vn.coccoc.pubsub.model.PubSubModel.CommonResponse pubMessage(vn.coccoc.pubsub.model.PubSubModel.PubSubMessage request) {
      return blockingUnaryCall(
          getChannel(), getPubMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage subMessage(vn.coccoc.pubsub.model.PubSubModel.CommonRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcPubSubServiceFutureStub extends io.grpc.stub.AbstractStub<GrpcPubSubServiceFutureStub> {
    private GrpcPubSubServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcPubSubServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPubSubServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcPubSubServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> subcribe(
        vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request) {
      return futureUnaryCall(
          getChannel().newCall(getSubcribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> unsubcribe(
        vn.coccoc.pubsub.model.PubSubModel.SubcribeContent request) {
      return futureUnaryCall(
          getChannel().newCall(getUnsubcribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vn.coccoc.pubsub.model.PubSubModel.CommonResponse> pubMessage(
        vn.coccoc.pubsub.model.PubSubModel.PubSubMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getPubMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage> subMessage(
        vn.coccoc.pubsub.model.PubSubModel.CommonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBCRIBE = 0;
  private static final int METHODID_UNSUBCRIBE = 1;
  private static final int METHODID_PUB_MESSAGE = 2;
  private static final int METHODID_SUB_MESSAGE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcPubSubServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcPubSubServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBCRIBE:
          serviceImpl.subcribe((vn.coccoc.pubsub.model.PubSubModel.SubcribeContent) request,
              (io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse>) responseObserver);
          break;
        case METHODID_UNSUBCRIBE:
          serviceImpl.unsubcribe((vn.coccoc.pubsub.model.PubSubModel.SubcribeContent) request,
              (io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse>) responseObserver);
          break;
        case METHODID_PUB_MESSAGE:
          serviceImpl.pubMessage((vn.coccoc.pubsub.model.PubSubModel.PubSubMessage) request,
              (io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.CommonResponse>) responseObserver);
          break;
        case METHODID_SUB_MESSAGE:
          serviceImpl.subMessage((vn.coccoc.pubsub.model.PubSubModel.CommonRequest) request,
              (io.grpc.stub.StreamObserver<vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcPubSubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcPubSubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return vn.coccoc.pubsub.service.PubSubService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcPubSubService");
    }
  }

  private static final class GrpcPubSubServiceFileDescriptorSupplier
      extends GrpcPubSubServiceBaseDescriptorSupplier {
    GrpcPubSubServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcPubSubServiceMethodDescriptorSupplier
      extends GrpcPubSubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcPubSubServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcPubSubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcPubSubServiceFileDescriptorSupplier())
              .addMethod(getSubcribeMethod())
              .addMethod(getUnsubcribeMethod())
              .addMethod(getPubMessageMethod())
              .addMethod(getSubMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
