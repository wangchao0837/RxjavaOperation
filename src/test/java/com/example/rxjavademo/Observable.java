package com.example.rxjavademo;

public class Observable<T> {


    private ObservableOnSubscribe observableOnSubscribe;

    private Observable(ObservableOnSubscribe observableOnSubscribe) {
        this.observableOnSubscribe = observableOnSubscribe;
    }


    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        Observable<T> observable = new Observable(observableOnSubscribe);
        return observable;
    }


    public void subscribe(Observer<? extends T> observer) {
        observableOnSubscribe.onSubscribe(observer);
    }

}
