package vn.coccoc.hungbv2.pubsub.client.app;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcClient;
import vn.coccoc.hungbv2.pubsub.client.base.GrpcServiceStubFactory;
import vn.coccoc.hungbv2.pubsub.client.scheduler.jobs.PeriodicallySubMessage;
import vn.coccoc.pubsub.model.PubSubModel.SubcribeContent;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc;
import vn.coccoc.pubsub.service.GrpcPubSubServiceGrpc.GrpcPubSubServiceBlockingStub;


public class ClientSubApp {

  public static void main(String[] args) {
    //-DclientCredentical=test -DtopicName=test -DclientName=app1 -DgrpcBrokerHost=localhost -DgrpcBrokerPort=2180 -DjobPriority=10 -DjobIntervalInSecond=10 -DschedulerDelayInSecond=10
    String clientName = System.getProperty("clientName") != null ? System.getProperty("clientName")
        : "default_name";
    String clientCredentical =
        System.getProperty("clientCredentical") != null ? System.getProperty("clientCredentical")
            : "password";
    String topicName =
        System.getProperty("topicName") != null ? System.getProperty("topicName") : "default_topic";
    String grpcBrokerHost =
        System.getProperty("grpcBrokerHost") != null ? System.getProperty("grpcBrokerHost")
            : "localhost";
    Integer grpcBrokerPort = Integer.parseInt(
        System.getProperty("grpcBrokerPort") != null ? System.getProperty("grpcBrokerPort")
            : "2180");
    int jobPriority = Integer.parseInt(
        System.getProperty("jobPriority") != null ? System.getProperty("jobPriority")
            : "10");
    int jobIntervalInSecond = Integer.parseInt(
        System.getProperty("jobIntervalInSecond") != null ? System
            .getProperty("jobIntervalInSecond")
            : "5");
    int schedulerDelayInSecond = Integer.parseInt(
        System.getProperty("schedulerDelayInSecond") != null ? System
            .getProperty("schedulerDelayInSecond")
            : "10");
    /*
    * -1 to get previous Index from Broker
    * x, x >= 0 for specify a custom sub message
    * */
    int fromIndex = Integer.parseInt(
        System.getProperty("fromIndex") != null ? System
            .getProperty("fromIndex")
            : "-1");
    SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    GrpcClient grpcClient = new GrpcClient(grpcBrokerHost, grpcBrokerPort, null);
    GrpcServiceStubFactory stubFactory = new GrpcServiceStubFactory(grpcClient);

    GrpcPubSubServiceBlockingStub stub = stubFactory
        .getBlockingStubService(GrpcPubSubServiceGrpc.class,
            GrpcPubSubServiceBlockingStub.class);
    SubcribeContent initSub = SubcribeContent.newBuilder()
        .setClientName(clientName)
        .setTopicName(topicName)
        .setCredentical(clientCredentical)
        .build();
    try {
      System.out.println(stub.subcribe(initSub));
      Scheduler scheduler = schedulerFactory.getScheduler();
      JobDetail job = JobBuilder.newJob(PeriodicallySubMessage.class)
          .withIdentity(clientName, topicName)
          .usingJobData("clientName", clientName)
          .usingJobData("clientCredentical", clientCredentical)
          .usingJobData("topicName", topicName)
          .usingJobData("grpcBrokerHost", grpcBrokerHost)
          .usingJobData("grpcBrokerPort", grpcBrokerPort)
          .usingJobData("fromIndex", fromIndex)
          .build();
      Trigger trigger = TriggerBuilder.newTrigger()
          .withIdentity(clientName, topicName)
          .startNow()
          .withPriority(jobPriority)
          .withSchedule(SimpleScheduleBuilder
              .simpleSchedule()
              .withIntervalInSeconds(jobIntervalInSecond)
              .repeatForever()
          )
          .build();
      scheduler.scheduleJob(job, trigger);
      scheduler.startDelayed(schedulerDelayInSecond);
    } catch (SchedulerException e) {
      e.printStackTrace();
    }

  }

}
