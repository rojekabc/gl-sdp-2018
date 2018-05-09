package com.gl.sdp.pricecoin.sl;

import java.io.Serializable;
import java.math.BigDecimal;

public class CoinInfoSO implements Serializable {
    private String coin;
    private String assetCoin;
    private BigDecimal quantity;
    private String exchange;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAssetCoin() {
        return assetCoin;
    }

    public void setAssetCoin(String assetCoin) {
        this.assetCoin = assetCoin;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
