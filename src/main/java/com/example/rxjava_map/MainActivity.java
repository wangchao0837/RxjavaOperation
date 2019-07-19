package com.example.rxjava_map;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjava_map.observable.Observable;
import com.example.rxjava_map.observer.Observer;
import com.example.rxjava_map.subscribe.ObservableOnSubscribe;
import com.example.rxjava_map.trasform.Function;
import com.example.rxjava_map.trasform.ObserverUser;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void onSubscribe(Observer<? super String> observer) {
                Log.e(TAG, "thread1   :" + Thread.currentThread().getName());
                observer.onNext("15");
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                Log.e(TAG, "thread2   :" + Thread.currentThread().getName());
                return Integer.valueOf(s);
            }
        }).subscribeOn()
                .observerOn()
                .subscribe(new ObserverUser<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {

                    }
                });

    }
}
