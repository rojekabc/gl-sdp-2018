package com.gl.sdp.pricecoin.sl;

import com.gl.sdp.pricecoin.bl.CoinPriceBO;
import org.springframework.stereotype.Component;

@Component
public class DataConverterComponent {
    public CoinInfoSO convert(CoinPriceBO coinPrice) {
        CoinInfoSO result = new CoinInfoSO();
        result.setAssetCoin(coinPrice.getAsset());
        result.setCoin(coinPrice.getCoin());
        result.setExchange(coinPrice.getExchange());
        result.setQuantity(coinPrice.getQuantity().toString());
        return result;
    }
}
