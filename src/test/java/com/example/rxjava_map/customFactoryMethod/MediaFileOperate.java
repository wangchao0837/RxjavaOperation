package com.example.rxjava_map.customFactoryMethod;

public class MediaFileOperate extends MediaProxy {
    @Override
    public IMediaPlayer factoryMethod() {
        return new FileMediaPlayer();
    }

    @Override
    public String getLogo() {
        return "华为";
    }


}
