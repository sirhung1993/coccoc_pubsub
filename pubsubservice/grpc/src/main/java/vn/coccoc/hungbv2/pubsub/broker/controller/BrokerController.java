package vn.coccoc.hungbv2.pubsub.broker.controller;

import vn.coccoc.pubsub.model.PubSubModel.CommonRequest;
import vn.coccoc.pubsub.model.PubSubModel.CommonResponse;
import vn.coccoc.pubsub.model.PubSubModel.ListPubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.PubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;

public interface BrokerController {

  CommonResponse subscribe(SubcribeContent subcribeContent);

  CommonResponse unsubscribe(SubcribeContent subcribeContent);

  CommonResponse pubMessage(PubSubMessage message);

  ListPubSubMessage subMessage(CommonRequest request);

}
