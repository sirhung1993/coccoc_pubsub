package vn.coccoc.hungbv2.pubsub.broker.core;


public interface ServiceContext {

  <T> T getInstance(Class<T> clazz);

}
