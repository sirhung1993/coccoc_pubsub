package vn.coccoc.hungbv2.pubsub.broker.controller.impl;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import vn.coccoc.hungbv2.pubsub.broker.controller.BrokerController;
import vn.coccoc.hungbv2.pubsub.broker.core.AbstractController;
import vn.coccoc.hungbv2.pubsub.broker.core.ServiceContext;
import vn.coccoc.pubsub.model.PubSubModel.CommonRequest;
import vn.coccoc.pubsub.model.PubSubModel.CommonResponse;
import vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.PubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;


public class BrokerControllerImpl extends AbstractController implements BrokerController {

  private Map<String, List<SubcribeContent>> subcriberByTopic = new HashMap<String, List<SubcribeContent>>();
  private Map<String, List<PubSubMessage>> messageInQueue = new HashMap<String, List<PubSubMessage>>();
  private Map<SubcribeContent, Integer> trackingTopicBySubriber = new HashMap<SubcribeContent, Integer>();

  public BrokerControllerImpl(ServiceContext serviceContext) {
    super(serviceContext);
  }

  public CommonResponse subscribe(SubcribeContent subcribeContent) {
    String topicName = subcribeContent.getTopicName();
    String clientName = subcribeContent.getClientName();
    String clientCredentical = subcribeContent.getCredentical();
    CommonResponse.Builder commonResponse = CommonResponse.newBuilder()
        .setStatusCode(Status.OK.getCode().toString());
    boolean topicExist = subcriberByTopic.containsKey(topicName);
    if (clientName.isEmpty() && clientCredentical.isEmpty()) {
      throw new StatusRuntimeException(Status.INVALID_ARGUMENT
          .withDescription("Please provide clientName and credentical phrase!"));
    }
    if (topicExist) {
      boolean subcriberExist = subcriberByTopic.get(topicName).contains(subcribeContent);
      if (subcriberExist) {
        commonResponse
            .setMessage("Subcriber already exist")
            .setStatusCode(Status.ALREADY_EXISTS.getCode().toString())
            .build();
      } else {
        subcriberByTopic.get(topicName).add(subcribeContent);
        commonResponse.setMessage("Subcribe suscessfully!").build();
      }
    } else {
      Vector<SubcribeContent> queue = new Vector<SubcribeContent>();
      queue.add(subcribeContent);
      subcriberByTopic.put(topicName, queue);
      trackingTopicBySubriber.put(subcribeContent, 0);
      commonResponse.setMessage("Create new topic and subcribe suscessfully!").build();
    }
    return commonResponse.build();
  }

  public CommonResponse unsubscribe(SubcribeContent subcribeContent) {
    String topicName = subcribeContent.getTopicName();
    String clientName = subcribeContent.getClientName();
    String clientCredentical = subcribeContent.getCredentical();
    CommonResponse.Builder commonResponse = CommonResponse.newBuilder()
        .setStatusCode(Status.OK.getCode().toString());
    boolean topicExist = subcriberByTopic.containsKey(topicName);
    if (clientName.isEmpty() && clientCredentical.isEmpty()) {
      throw new StatusRuntimeException(
          Status.INVALID_ARGUMENT
              .withDescription("Please provide clientName and credentical phrase!"));
    }
    if (topicExist) {
      boolean status = subcriberByTopic.get(topicName).remove(subcribeContent);
      if (status) {
        trackingTopicBySubriber.remove(subcribeContent);
        commonResponse.setMessage("Unsubcribe suscessfully!");
      } else {
        commonResponse
            .setStatusCode(Status.OUT_OF_RANGE.getCode().toString())
            .setMessage("Nothing to unsubcribe!").build();
      }

    } else {
      commonResponse
          .setStatusCode(Status.OUT_OF_RANGE.toString())
          .setMessage("No topic to unsubcribe!").build();
    }
    return commonResponse.build();
  }

  public CommonResponse pubMessage(PubSubMessage message) {
    String topicName = message.getTopic();
    boolean topicExist = subcriberByTopic.containsKey(topicName);
    CommonResponse.Builder commonResponse = CommonResponse.newBuilder()
        .setStatusCode(Status.OK.getCode().toString());
    int queueLenght = 0;
    if (topicExist) {
      if (messageInQueue.containsKey(topicName)) {
        List<PubSubMessage> queue = messageInQueue.get(topicName);
        queue.add(message);
        queueLenght = queue.size();

      } else {
        List<PubSubMessage> queue = new ArrayList<PubSubMessage>();
        queue.add(message);
        queueLenght = queue.size();
        messageInQueue.put(topicName, queue);
      }
      commonResponse
          .setMessage("Message is queued suscessfully!")
          .setQueueIndex(queueLenght)
          .build();
    } else {
      List<SubcribeContent> queueSub = new ArrayList<SubcribeContent>();
      subcriberByTopic.put(topicName, queueSub);
      List<PubSubMessage> queueMessage = new ArrayList<PubSubMessage>();
      queueMessage.add(message);
      messageInQueue.put(topicName, queueMessage);
      commonResponse
          .setStatusCode(Status.OK.getCode().toString())
          .setQueueIndex(queueMessage.size())
          .setMessage("Create topic and enqueue message suscessfully!").build();
    }
    return commonResponse.build();
  }

  @Override
  public ListPubSubMessage subMessage(CommonRequest request) {
    SubcribeContent subcribeContent = request.getClientInfo();
    String topicName = subcribeContent.getTopicName();
    int currentLength = 0;
    List<PubSubMessage> pubSubMessageList = null;
    List<PubSubMessage> shallowCopy = messageInQueue.containsKey(topicName) ? new ArrayList<PubSubMessage>(messageInQueue.get(topicName)) : new ArrayList<PubSubMessage>();
    boolean topicExist = subcriberByTopic.containsKey(topicName);
    if (topicExist) {
      int previousIndex = request.getQueueIndex() >= 0 ? request.getQueueIndex()
          : trackingTopicBySubriber.get(subcribeContent);
      List<SubcribeContent> subByContent = subcriberByTopic.get(topicName);
      boolean isClientValid = subByContent.contains(subcribeContent);
      if (isClientValid) {
        if (messageInQueue.containsKey(topicName)) {
          currentLength = shallowCopy.size();
          pubSubMessageList = shallowCopy.subList(previousIndex, currentLength);
        }
      } else {
        throw new StatusRuntimeException(Status.PERMISSION_DENIED
            .withDescription("Please provide correct clientName and credentical phrase!"));
      }
    } else {
      List<SubcribeContent> queue = new ArrayList<SubcribeContent>();
      queue.add(subcribeContent);
      subcriberByTopic.put(topicName, queue);
    }
    int currentIndex = currentLength != 0 ? currentLength - 1 : 0;
    trackingTopicBySubriber.put(subcribeContent, currentIndex);
    return ListPubSubMessage.newBuilder()
        .addAllListPubSubMessage(pubSubMessageList)
        .setQueueIndex(currentIndex)
        .build();
  }
}
