package com.example.rxjava_map.trasform;

import com.example.rxjava_map.observer.Observer;

public class OperatorMap<T, R> implements OperateFunction<T, R> {


    private final Function function;

    public <T, R> OperatorMap(Function<? super T, ? extends R> function) {
        this.function = function;
    }

    //传入下面的observer传入当前的observer并返回
    @Override
    public Observer<? super T> apply(Observer<? super R> observable) {
        return new MapScriber<>(observable, function);
    }

    //内置观察者
    class MapScriber<T, R> implements Observer<T> {


        private final Function<? super T, ? extends R> function;
        private final Observer<? super R> outSideObserver;

        public MapScriber(Observer<? super R> observable, Function<? super T, ? extends R> function) {
            this.outSideObserver = observable;
            this.function = function;
        }

        @Override
        public void onNext(T t) {
            R apply = function.apply(t);
            outSideObserver.onNext(apply);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

}
