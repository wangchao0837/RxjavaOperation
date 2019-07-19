package com.example.rxjava_map.observable;

import android.os.Handler;
import android.os.Looper;

import com.example.rxjava_map.observer.Observer;
import com.example.rxjava_map.subscribe.ObservableOnSubscribe;

import java.util.logging.LogRecord;


class OnObservableSchudelMain<T> implements ObservableOnSubscribe<T> {

    private final ObservableOnSubscribe<T> observableOnSubscribe;

    public OnObservableSchudelMain(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.observableOnSubscribe = observableOnSubscribe;
    }


    @Override
    public void onSubscribe(Observer<? super T> observer) {
        ScheulderMainSub scheulderMainSub = new ScheulderMainSub(observer);
        observableOnSubscribe.onSubscribe(scheulderMainSub);
    }


    class ScheulderMainSub<T> implements Observer<T>{


        private final Observer<? super T> observer;
        private final Handler handler;

        public ScheulderMainSub(Observer<? super T> observer) {
            super();
            this.observer = observer;
            handler = new Handler(Looper.getMainLooper());

        }

        @Override
        public void onNext(final T t) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    observer.onNext(t);
                }
            });
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }


}
