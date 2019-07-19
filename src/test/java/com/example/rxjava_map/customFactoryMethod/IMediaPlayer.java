package com.example.rxjava_map.customFactoryMethod;

public interface IMediaPlayer {

    void init(String name);

    byte[] Resource(int id);

    void play(byte[] origin);

}
