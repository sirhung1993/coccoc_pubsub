package vn.coccoc.hungbv2.pubsub.broker.base;

import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ExceptionHandler {
    public static <T extends GeneratedMessageV3> void handle(StreamObserver<T> responseObserver, Exception exception) {
      if (exception instanceof StatusRuntimeException) {
        responseObserver.onError((StatusRuntimeException) exception);
      } else if (exception instanceof NullPointerException) {
        // TODO: Response friendly for NullPointerException
        // TODO: Write log replace for printStackTrace
        exception.printStackTrace();
        responseObserver.onError(
            Status.INTERNAL.withDescription("Got NullPointerException: " + exception.getMessage()).asRuntimeException());
        // TODO: Add other exception here
      } else {
        // TODO: Write log replace for printStackTrace
        exception.printStackTrace();
        responseObserver
            .onError(Status.INTERNAL.withDescription("Got Exception:" + exception.getMessage()).asRuntimeException());
      }
    }

}
