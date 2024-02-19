package com.solutions.practice2.SalesTxn17_02Soln.lambda;

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
