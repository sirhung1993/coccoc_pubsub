# Non-Persistence Publish-Subcribe Queue

## Overview

![PubSub](https://user-images.githubusercontent.com/8535911/63535158-00e10500-c53b-11e9-968e-f88827eb8df0.png)


## Properties

* gRPC protocol
* Protobuf compatible
* In memory caching
* Non-persistence
* Non-threadsafe
* Follow Kafka mechanism

## Quick Start Guide

1. Clone the reposiry
2. Set **$PUB_SUB_HOME** is project working dir 
```bash
    cd ./pubsubservice
    export PUB_SUB_HOME=$(pwd)
    echo $PUB_SUB_HOME
```
3. Run the following command
```bash
   cd $PUB_SUB_HOME
   mvn clean install 
```
4. Start gRPC broker by using  
```bash
  cd $PUB_SUB_HOME/grpc
  mvn spring-boot:run
``` 
5. Start periodically publish message app
```bash
  cd $PUB_SUB_HOME/client
  mvn exec:java -Dexec.mainClass="vn.coccoc.hungbv2.pubsub.client.app.ClientPubApp" -DclientName=<name> -DclientCredentical=<some_string> -DtopicName=<topicTest>
  -DgrpcBrokerHost=<localhost> -DgrpcBrokerPort=<portInNumber> -DjobPriority=<pritorityInNumber> -DjobIntervalInSecond=<numberSecond> -DschedulerDelayInSecond=<numberSecondDelay>
```
6. Start periodically subcribe message app
```bash
cd $PUB_SUB_HOME/client
  mvn exec:java -Dexec.mainClass="vn.coccoc.hungbv2.pubsub.client.app.ClientSubApp" -DclientName=<name> -DclientCredentical=<some_string> -DtopicName=<topicTest>
  -DgrpcBrokerHost=<localhost> -DgrpcBrokerPort=<portInNumber> -DjobPriority=<pritorityInNumber> -DjobIntervalInSecond=<numberSecond> -DschedulerDelayInSecond=<numberSecondDelay
```
7. Start as many publishing and subcribing appa as you want, remember to change **clientName** and **clientCredentical**.

## Known Problems

1. Concurrency exception (temp fix by shallow copy).
2. Race-condition could happen.
3. Memory limitation.
4. No clear and persist collection.

## Testing Environments

* Ubuntu 18 (4.15.0-58-generic #64-Ubuntu)
* openjdk version "1.8.0_222"
* Apache Maven 3.6.0