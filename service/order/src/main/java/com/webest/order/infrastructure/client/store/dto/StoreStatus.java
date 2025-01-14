package com.webest.order.infrastructure.client.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreStatus {
    OPEN("영업 중"), PREPARING("준비 중"), CLOSED("영업 종료");
    private final String description;
}
