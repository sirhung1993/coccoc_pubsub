package vn.coccoc.hungbv2.pubsub.broker.core;

public abstract class AbstractController {

  protected final ServiceContext serviceContext;

  public AbstractController(ServiceContext serviceContext) {
    this.serviceContext = serviceContext;
  }
}