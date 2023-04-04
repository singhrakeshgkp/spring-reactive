package com.reactiveex.reactiveweb5.subscriptions;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class TestSubscription implements Subscription {
    private int lastReqEle=-1;
    private final Subscriber subscriber;
    private final List<Integer> list;

    public TestSubscription(Subscriber subscriber, List<Integer> list) {
        this.subscriber = subscriber;
        this.list = list;
    }

    @Override
    public void request(long l) {
        lastReqEle++;
        if(lastReqEle<list.size()) {
            subscriber.onNext(list.get(lastReqEle));
        }else{
            subscriber.onComplete();
        }

    }

    @Override
    public void cancel() {

    }
}
