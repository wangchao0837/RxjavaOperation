package com.example.rxjava_map.observable;

import com.example.rxjava_map.observer.Observer;
import com.example.rxjava_map.subscribe.ObservableOnSubscribe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnObservableSchudelIo<T> implements ObservableOnSubscribe<T> {

    private final Observable<T> tObservable;
    private final ExecutorService executorService;

    public OnObservableSchudelIo(Observable<T> tObservable) {
        this.tObservable = tObservable;
        executorService = Executors.newSingleThreadExecutor();
    }


    @Override
    public void onSubscribe(Observer<? super T> observer) {
        final ScheulderIoSub scheulderIoSub = new ScheulderIoSub(observer);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                tObservable.subscribe(scheulderIoSub);
            }
        });
    }



    class ScheulderIoSub<T> implements Observer<T>{


        private final Observer<? super T> observer;

        public ScheulderIoSub(Observer<? super T> observer) {
            super();
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }




}
