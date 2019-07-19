package com.example.rxjava_map.trasform;

import com.example.rxjava_map.observer.Observer;

public abstract class ObserverUser<T> implements Observer<T> {
    @Override
    public void onNext(T t) {

    }
}
