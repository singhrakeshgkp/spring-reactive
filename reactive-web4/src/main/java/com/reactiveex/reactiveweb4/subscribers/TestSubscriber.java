package com.reactiveex.reactiveweb4.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber implements Subscriber<Integer> {

    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("subscribed");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer integer) {

        System.out.println("value "+integer);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("error "+throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("completed");
    }
}
