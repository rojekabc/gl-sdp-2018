package com.gl.sdp.pricecoin.bl;

import com.gl.sdp.pricecoin.dl.Exchange;

import java.math.BigDecimal;

public class CoinPriceBO {
    private final String exchange;
    private final String coin;
    private final String asset;
    private final BigDecimal quantity;

    public CoinPriceBO(String exchange, String coin, String assetCoin, BigDecimal quantity) {
        this.exchange = exchange;
        this.coin = coin;
        this.asset = assetCoin;
        this.quantity = quantity;
    }

    public String getExchange() {
        return exchange;
    }

    public String getCoin() {
        return coin;
    }

    public String getAsset() {
        return asset;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
