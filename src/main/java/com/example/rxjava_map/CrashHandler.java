package com.example.rxjava_map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

    public CrashHandler() {
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        try {
            new Thread().sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        defaultUncaughtExceptionHandler.uncaughtException(t, e);
    }


}
