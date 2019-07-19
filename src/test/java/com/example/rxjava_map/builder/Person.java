package com.example.rxjava_map.builder;

public class Person {
    private String hand;
    private String arm;
    private String leg;
    private String nose;
    private String ear;
    private String mouth;


    private Person(PersonBuilder.Params params) {
        hand = params.hand;
        arm = params.arm;
        leg = params.leg;
        nose = params.nose;
        ear = params.ear;
        mouth = params.mouth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hand='" + hand + '\'' +
                ", arm='" + arm + '\'' +
                ", leg='" + leg + '\'' +
                ", nose='" + nose + '\'' +
                ", ear='" + ear + '\'' +
                ", mouth='" + mouth + '\'' +
                '}';
    }


    public static class PersonBuilder {


        private final Params params;

        public PersonBuilder() {
            params = new Params();
        }

        public PersonBuilder hand(String hand) {
            params.hand = hand;
            return this;
        }

        public PersonBuilder leg(String leg) {
            params.leg = leg;
            return this;
        }

        public PersonBuilder arm(String arm) {
            params.arm = arm;
            return this;
        }

        public PersonBuilder nose(String nose) {
            params.nose = nose;
            return this;
        }

        public PersonBuilder ear(String ear) {
            params.ear = ear;
            return this;
        }

        public PersonBuilder mouth(String mouth) {
            params.mouth = mouth;
            return this;
        }

        public Person build() {
            return new Person(params);
        }


        class Params {
            public String hand;
            public String arm;
            public String leg;
            public String nose;
            public String ear;
            public String mouth;
        }

    }
}
