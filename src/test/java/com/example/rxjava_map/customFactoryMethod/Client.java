package com.example.rxjava_map.customFactoryMethod;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        MediaProxy mediaFactory = new MediaNetwordOperate();
        byte[] source = mediaFactory.source(2);
    }
}
