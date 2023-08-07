package com.reactive.subscriptions;

import java.util.List;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscription implements Subscription {

  private int lastReqEle = -1;
  private  final Subscriber subscriber;
  private final List<Integer> numbers;

  public TestSubscription(Subscriber subscriber, List<Integer> numbers){

    this.subscriber = subscriber;
    this.numbers = numbers;
  }
  @Override
  public void request(long l) {

    lastReqEle++;
    if(lastReqEle < numbers.size()){
      subscriber.onNext(numbers.get(lastReqEle));
    }else{
      subscriber.onComplete();
    }
  }

  @Override
  public void cancel() {

  }
}
