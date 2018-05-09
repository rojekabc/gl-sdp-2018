package com.gl.sdp.pricecoin.sl;

import com.gl.sdp.pricecoin.bl.CoinPriceBO;
import com.gl.sdp.pricecoin.bl.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class CoinEndpointImpl implements CoinEndpoint {
    @Autowired
    private CoinService coinService;

    @Autowired
    private DataNeutralizerComponent neutralizer;

    @Autowired
    private DataConverterComponent converter;

    @Override
    public void setCoinPrice(
            @PathVariable(name = "exchange") String exchange,
            @RequestBody CoinPriceSO request) {
        coinService.setCoinPrice(
                neutralizer.neutralize(exchange),
                neutralizer.neutralize(request.getCoin()),
                neutralizer.neutralize(request.getAssetCoin()),
                new BigDecimal(neutralizer.neutralize(request.getQuantity())));
    }

    @Override
    public List<CoinInfoSO> getCoinPrices(
            @RequestHeader(name = "user") String user,
            @PathVariable(name = "coin") String coin,
            @RequestParam(name = "exchange", required = false) String exchange,
            @RequestParam(name = "asset", required = false) String asset) {
        List<CoinPriceBO> coinPrices = coinService.getCoinPrices(user, coin, exchange, asset);
        return coinPrices.stream() //
                .map(converter::convert) //
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCoinList()
    {
        return coinService.listCoins();
    }
}
