package com.example.rxjava_map.myenum;

public class Pupil {

    private static class PupilIn {
        private static Pupil INSTANCE = new Pupil();
    }


    public static Pupil getInstance() {
        return PupilIn.INSTANCE;
    }

    private Pupil(){

    }

}
