package com.practices.practice3.SalesTxn17_03Prac.lambda;

public enum State {
    CA("CA"),
    CO("CO"),
    MA("MA");

    private final String str;

    State(String stateStr) {
        this.str = stateStr;
    }

    public String getStr() {
        return str;
    }
}
