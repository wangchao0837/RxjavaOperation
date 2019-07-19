package com.example.rxjava_map.observer;

public interface  Observer<T> {
    public  void onNext(T t);
    public  void onError(Throwable e);
    public  void onComplete();
}
