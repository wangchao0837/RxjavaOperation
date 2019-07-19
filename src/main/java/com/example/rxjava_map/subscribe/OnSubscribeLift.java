package com.example.rxjava_map.subscribe;

import com.example.rxjava_map.observer.Observer;
import com.example.rxjava_map.trasform.Function;
import com.example.rxjava_map.trasform.OperatorMap;

public class OnSubscribeLift<T, R> implements ObservableOnSubscribe<R> {

    ObservableOnSubscribe<T> parent;
    private final OperatorMap<T, R> operatorMap;

    public <T> OnSubscribeLift(ObservableOnSubscribe observableOnSubscribe, Function<? super T, ? extends R> function) {
        this.parent = observableOnSubscribe;
        operatorMap = new OperatorMap(function);
    }


    @Override
    public void onSubscribe(Observer<? super R> observer) {
        Observer<? super T> apply = operatorMap.apply(observer);
        parent.onSubscribe(apply);
    }
}
