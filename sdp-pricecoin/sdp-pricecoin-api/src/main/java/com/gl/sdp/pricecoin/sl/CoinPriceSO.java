package com.gl.sdp.pricecoin.sl;

import java.io.Serializable;
import java.math.BigDecimal;

public class CoinPriceSO implements Serializable {
    private String coin;
    private String assetCoin;
    private String quantity;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
