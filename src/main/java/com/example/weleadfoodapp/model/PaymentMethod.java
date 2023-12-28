package com.example.weleadfoodapp.model;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    CASH(0f), CREDIT_CARD(0.2f);
    private final float discount;

    PaymentMethod(final float discount) {
        this.discount = discount;
    }

    public static PaymentMethod getDefault() {
        return CREDIT_CARD;
    }
}