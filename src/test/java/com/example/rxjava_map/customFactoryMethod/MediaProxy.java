package com.example.rxjava_map.customFactoryMethod;

public abstract class MediaProxy {

    public byte[] source(int id) {
        IMediaPlayer iMediaPlayer = factoryMethod();
        iMediaPlayer.init(getLogo());
        byte[] resource = iMediaPlayer.Resource(id);
        iMediaPlayer.play(resource);
        return resource;
    }


    public abstract IMediaPlayer factoryMethod();
    public abstract String getLogo();

}
