package com.example.rxjava_map.observable;

import com.example.rxjava_map.observer.Observer;
import com.example.rxjava_map.subscribe.ObservableOnSubscribe;
import com.example.rxjava_map.subscribe.OnSubscribeLift;
import com.example.rxjava_map.trasform.Function;

public class Observable<T> {


    private ObservableOnSubscribe<T> observableOnSubscribe;

    private Observable(ObservableOnSubscribe observableOnSubscribe) {
        this.observableOnSubscribe = observableOnSubscribe;
    }


    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        Observable observable = new Observable(observableOnSubscribe);
        return observable;
    }


    public void subscribe(Observer<? super T> observer) {
        observableOnSubscribe.onSubscribe(observer);
    }

    public <R> Observable<R> map(Function<? super T, ? extends R> function) {
        return new Observable(new OnSubscribeLift(observableOnSubscribe, function));
    }

    public Observable<T> subscribeOn() {
        return Observable.create(new OnObservableSchudelIo<T>(this));
    }

    public Observable<T> observerOn() {
        return new Observable(new OnObservableSchudelMain(observableOnSubscribe));
    }


}
