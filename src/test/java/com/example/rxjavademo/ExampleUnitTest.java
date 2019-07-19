package com.example.rxjavademo;


import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        //是否满足条件
        Observable.just(1, 2, 3, 4).all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer > 0 && integer < 5;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println(aBoolean);
            }
        });


    }

    //    @Test
    public void contains() {
        //是否包含
        Observable.just(1, 2, 3, 4).contains(20).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println(aBoolean);
            }
        });
    }

    //    @Test
    public void any() {
        //又一个满足 为true
        Observable.just(1, 2, 3).any(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer > 2;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println(aBoolean);
            }
        });

    }

    //    @Test
    public void isEmpty() {
        //是否为空
        ArrayList<Object> objects = new ArrayList<>();
        Observable.empty().isEmpty().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println(aBoolean);
            }
        });
    }

    //    @Test
    public void defaultEmpty() {
        //为空是默认复制
        Observable.empty().defaultIfEmpty(1).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println(o);
            }
        });
    }

    //    @Test
    public void skipWhile() {
        Observable.just(1, 2, 3).skipWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                System.out.println("--" + integer);

                // return true:跳过当前进行下一次  false：不跳过，后边全部执行，以后不会再执行此方法
                return integer == 1 ? true : false;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }

    //    @Test
    public void startWith() {
        //发送数据最前 插入一条startwith数据
        Observable.just("hello", "word").startWith("he").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }

    //    @Test
    public void concat() {
        //按顺序一个一个执行，和时间无关
        Observable.concat(Observable.just(1, 2).delay(1000, TimeUnit.MILLISECONDS),
                Observable.just(3, 4).delay(500, TimeUnit.MILLISECONDS))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    //    @Test
    public void merge() {


        //按时间顺序执行
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
        }).delay(1000, TimeUnit.MILLISECONDS);
        Observable<Integer> just2 = Observable.just(4, 5, 6).delay(200, TimeUnit.MILLISECONDS);
        Observable.merge(just, just2).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }


    //    @Test
    public void test() {

        long time = 123434343;
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.putLong(time);
        long aLong = byteBuffer.getLong(0);
        System.out.println(aLong);

    }

    @Test
    public void merge2() {

    }


}