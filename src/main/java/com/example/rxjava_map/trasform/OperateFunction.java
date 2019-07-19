package com.example.rxjava_map.trasform;

import com.example.rxjava_map.observable.Observable;
import com.example.rxjava_map.observer.Observer;

public interface OperateFunction<T, R> extends Function<Observer<? super R>, Observer<? super T>> {
}
