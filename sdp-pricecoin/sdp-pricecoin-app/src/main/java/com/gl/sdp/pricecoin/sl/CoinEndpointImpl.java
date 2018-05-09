package com.gl.sdp.pricecoin.sl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CoinEndpointImpl implements CoinEndpoint {
    @Override
    public void setCoinPrice(
            @PathVariable(name = "exchange") String exchange,
            @RequestBody CoinPriceSO request) {

    }

    @Override
    public List<CoinInfoSO> getCoinPrices(
            @RequestHeader(name = "user") String user,
            @PathVariable(name = "coin") String coin,
            @RequestParam(name = "exchange", required = false) String exchange,
            @RequestParam(name = "asset", required = false) String asset) {
        return null;
    }

    @Override
    public List<String> getCoinList() {
        return Arrays.asList("BTC", "LSK", "ETH", "NEO");
    }
}
