package com.example.rxjava_map.builder;

import org.junit.Test;

public class client {
    @Test
    public void test(){
        Person nose = new Person.PersonBuilder()
                .arm("胳膊")
                .ear("耳朵")
                .hand("手")
                .leg("腿")
                .mouth("嘴")
                .nose("鼻子")
                .build();

        System.out.println(nose);
    }
}
