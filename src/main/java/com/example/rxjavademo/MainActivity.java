package com.example.rxjavademo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable.defer(new Callable<ObservableSource<Integer>>() {
//            @Override
//            public ObservableSource<Integer> call() throws Exception {
//                return Observable.just(1, 2, 3).delay(2000, TimeUnit.MILLISECONDS);
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                System.out.println(integer);
//            }
//        });


//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        ArrayList<Integer> integers2 = new ArrayList<>();
//        integers2.add(9);
//        integers2.add(8);
//        integers2.add(7);
//        integers2.add(6);
//
//        Observable<Integer> integerObservable = Observable.fromIterable(integers);
//        Observable<Integer> integerObservable2 = Observable.fromIterable(integers2);
//        Observable.zip(integerObservable, integerObservable2, new BiFunction<Integer, Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) throws Exception {
//                return integer + integer2;
//            }
//        }).buffer(2).subscribe(new Consumer<List<Integer>>() {
//            @Override
//            public void accept(List<Integer> integers) throws Exception {
//                System.out.println(integers.toString());
//            }
//        });

//

//        Observable.concat(Observable.just(1, 2).delay(1000, TimeUnit.MILLISECONDS),
//                Observable.just(3, 4).delay(500, TimeUnit.MILLISECONDS))
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        System.out.println(integer);
//                    }
//                });


        Observable<Integer> just = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 1; i < 4; i++) {
                    if (i == 3) {
                        throw new Exception();
                    }
                    emitter.onNext(i);
                }
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                return Observable.empty();
            }
        }).delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        Observable<Integer> just2 = Observable.just(4, 5, 6).delay(200, TimeUnit.MILLISECONDS);
        Observable.merge(just, just2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }


}
