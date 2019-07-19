package com.example.rxjava_map.subscribe;

import com.example.rxjava_map.observer.Observer;

public interface ObservableOnSubscribe<T> extends Action1<Observer<? super T>> {
}
