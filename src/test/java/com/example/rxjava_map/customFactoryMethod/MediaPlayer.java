package com.example.rxjava_map.customFactoryMethod;

public abstract class MediaPlayer implements IMediaPlayer {

    @Override
    public void init(String name) {
        System.out.println("我想买" + name + "电脑");
    }

    @Override
    public byte[] Resource(int id) {
        return resource(id);
    }


    @Override
    public void play(byte[] origin) {
        System.out.println("买了一个" + origin.length + "的电脑");
    }

    public abstract byte[] resource(int id);

}
