package com.practices.practice1.SalesTxn17_01Prac.lambda;

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