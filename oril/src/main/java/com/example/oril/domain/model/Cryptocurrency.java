package com.example.oril.domain.model;

import lombok.Getter;

@Getter
public enum Cryptocurrency {
    BTC("/BTC/USD"), ETH("/ETH/USD"), XRP("/XRP/USD");

    private String url;

    Cryptocurrency(String url){
        this.url = url;
    }

}
