package vn.coccoc.hungbv2.pubsub.client.scheduler.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.pubsub.model.PubSubModel.CommonRequest;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;

public class PeriodicallySubMessage implements Job {

  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
    String clientName = jobDataMap.getString("clientName");
    String clientCredentical = jobDataMap.getString("clientCredentical");
    String topicName = jobDataMap.getString("topicName");
    String grpcBrokerHost = jobDataMap.getString("grpcBrokerHost");
    int grpcBrokerPort = jobDataMap.getInt("grpcBrokerPort");
    int fromIndex = jobDataMap.getInt("fromIndex");
    System.out.println(String
        .format("\nClient Name: %s"
                + "\nClient Credentical: %s"
                + "\nSubcribing Topic: %s"
                + "\nBroker host:%s"
                + "\nBrpler port: %s"
                + "\nGet message at: %d"
                + "\n------------------", clientName,
            clientCredentical, topicName, grpcBrokerHost, grpcBrokerPort, System.currentTimeMillis()));
    GrpcClient grpcClient = new GrpcClient(grpcBrokerHost, grpcBrokerPort, null);
    GrpcServiceStubFactory stubFactory = new GrpcServiceStubFactory(grpcClient);

    GrpcPubSubServiceBlockingStub stub = stubFactory
        .getBlockingStubService(GrpcPubSubServiceGrpc.class,
            GrpcPubSubServiceBlockingStub.class);

    SubcribeContent sub = SubcribeContent.newBuilder()
        .setClientName(clientName)
        .setCredentical(clientCredentical)
        .setTopicName(topicName)
        .build();

    System.out.println(stub.subMessage(CommonRequest.newBuilder()
        .setClientInfo(sub)
        .setQueueIndex(fromIndex)
        .build()));
  }
}
