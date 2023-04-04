package com.reactiveex.reactiveweb5.publishers;

import com.reactiveex.reactiveweb5.subscriptions.TestSubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class TestPublisher implements Publisher<Integer> {

    private final List<Integer> list;

    public TestPublisher(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {

        Subscription subscription = new TestSubscription(subscriber,list);
        subscriber.onSubscribe(subscription);
    }
}
