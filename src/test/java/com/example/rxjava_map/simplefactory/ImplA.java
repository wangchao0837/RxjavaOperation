package com.example.rxjava_map.simplefactory;

/**
 * Created by 48608 on 2018/2/28.
 */

public class ImplA implements Api {
    @Override
    public void operator() {
        System.out.println("完成了一种操作A");
    }
}
