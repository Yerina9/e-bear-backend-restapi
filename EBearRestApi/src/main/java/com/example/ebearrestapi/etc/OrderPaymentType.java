package com.example.ebearrestapi.etc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPaymentType {
    TYPE("OP_NUMBER");

    private final String prefix;
}
