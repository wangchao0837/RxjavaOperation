package com.example.rxjava_map.customFactoryMethod;

public class FileMediaPlayer extends MediaPlayer {


    @Override
    public void init(String name) {
        super.init(name);
        System.out.println("配置" + name + "电脑");
    }

    @Override
    public byte[] resource(int id) {
        byte[] bytes;
        if (id == 1) {
            bytes = new byte[128];
        } else {
            bytes = new byte[256];
        }
        return bytes;
    }
}
