package com.example.rxjava_map.myenum;


import org.junit.Test;

public class client {

    //    @Test
    public void testenum() {
        Product p = Product.CHEAP;
        System.out.println(p.hashCode());

        Product p2 = Product.HEAVIY;
        System.out.println(p2.hashCode());

        Product p3 = Product.CHEAP;
        System.out.println(p3.hashCode());
    }

    @Test
    public void testPrivate() {
        Pupil instance = Pupil.getInstance();
        System.out.println(instance);
        Pupil instance1 = Pupil.getInstance();
        System.out.println(instance1);
        Pupil instance2 = Pupil.getInstance();
        System.out.println(instance2);
    }

}
