package com.example.rxjava_map.customFactoryMethod;

public class MediaNetwordOperate extends MediaProxy {
    @Override
    public IMediaPlayer factoryMethod() {
        return new NetworkMediaPlayer();
    }

    @Override
    public String getLogo() {
        return "iphone";
    }


}
