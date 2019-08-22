package vn.coccoc.hungbv2.pubsub.client.scheduler.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.pubsub.model.PubSubModel.CommonRequest;
import vn.coccoc.pubsub.model.PubSubModel.PubSubMessage;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;

public class PeriodicallyPubMessage implements Job {

  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
    String clientName = jobDataMap.getString("clientName");
    String clientCredentical = jobDataMap.getString("clientCredentical");
    String topicName = jobDataMap.getString("topicName");
    String grpcBrokerHost = jobDataMap.getString("grpcBrokerHost");
    Integer grpcBrokerPort = jobDataMap.getInt("grpcBrokerPort");

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

    System.out.println(stub.pubMessage(PubSubMessage.newBuilder()
        .setFrom(clientName)
        .setTopic(topicName)
        .setContent(String.valueOf(System.currentTimeMillis()))
        .build()));
  }
}
