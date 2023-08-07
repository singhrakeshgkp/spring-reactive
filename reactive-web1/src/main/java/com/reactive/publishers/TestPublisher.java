package com.reactive.publishers;

import com.reactive.subscriptions.TestSubscription;
import java.util.List;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestPublisher implements Publisher<Integer> {

  private final List<Integer> numbers;

  public TestPublisher(List<Integer> numbers){
    this.numbers = numbers;
  }
  @Override
  public void subscribe(Subscriber<? super Integer> subscriber) {

    Subscription subscription = new TestSubscription(subscriber,numbers);
    subscriber.onSubscribe(subscription);
  }
}
