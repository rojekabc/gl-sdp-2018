package com.gl.sdp.pricecoin.dl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinPriceDao extends CrudRepository<CoinPrice, Long> {
    @Query("SELECT coin FROM CoinPrice coin WHERE coin.coin = ?2 AND coin.assetCoin = ?3 AND coin.exchange.name = ?1")
    CoinPrice findCoinPrice(String exchangeName, String coin, String asset);

    List<CoinPrice> findByCoinAndAssetCoin(String coin, String asset);

    List<CoinPrice> findByExchangeNameAndCoin(String exchange, String coin);

    List<CoinPrice> findByCoin(String coin);

    @Query("SELECT DISTINCT(coin.coin) FROM CoinPrice coin")
    List<String> listCoins();
}
