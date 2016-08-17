package com.exist.model.ref;


public enum ResultOrder {
    ASC(1),
    DESC(-1);

    int multiplier;

    ResultOrder(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
