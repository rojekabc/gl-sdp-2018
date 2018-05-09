package com.gl.sdp.pricecoin.bl;

import com.gl.sdp.pricecoin.dl.CoinPrice;
import com.gl.sdp.pricecoin.dl.CoinPriceDao;
import com.gl.sdp.pricecoin.dl.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinService {

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private CoinPriceDao coinPriceDao;

    @Transactional
    public void setCoinPrice(String exchangeName, String coin, String asset, BigDecimal quantity) {
        // find exchange or create new one
        Exchange exchange = exchangeService.findOrCreateExchange(exchangeName);

        // find that coin price is already set to exchange
        CoinPrice coinPrice = coinPriceDao.findCoinPrice(exchangeName, coin, asset);

        if (coinPrice == null) {
            // create new record
            coinPrice = new CoinPrice();
            coinPrice.setAssetCoin(asset);
            coinPrice.setCoin(coin);
            coinPrice.setExchange(exchange);
            coinPrice.setQuantity(quantity);
            coinPrice = coinPriceDao.save(coinPrice);
        } else {
            coinPrice.setQuantity(quantity);
        }
    }

    public List<CoinPriceBO> getCoinPrices(String user, String coin, String exchange, String asset) {
        List<CoinPrice> coinPrices;
        // retrieve data
        if (exchange == null) {
            if ( asset == null) {
                coinPrices = coinPriceDao.findByCoin(coin);
            } else {
                coinPrices = coinPriceDao.findByCoinAndAssetCoin(coin, asset);
            }
        } else {
            if ( asset == null ) {
                coinPrices = coinPriceDao.findByExchangeNameAndCoin(exchange, coin);
            } else {
                coinPrices = Arrays.asList(coinPriceDao.findCoinPrice(exchange, coin, asset));
            }
        }
        // convert to business object
        return coinPrices.stream() //
                .map(this::convert) //
                .collect(Collectors.toList());
    }

    public List<String> listCoins() {
        return coinPriceDao.listCoins();
        //.stream()
        //        .map(CoinPrice::getCoin)
        //        .collect(Collectors.toList());
    }

    public CoinPriceBO convert(CoinPrice coinPrice) {
        return new CoinPriceBO(
                coinPrice.getExchange().getName(),
                coinPrice.getCoin(),
                coinPrice.getAssetCoin(),
                coinPrice.getQuantity());
    }
}
