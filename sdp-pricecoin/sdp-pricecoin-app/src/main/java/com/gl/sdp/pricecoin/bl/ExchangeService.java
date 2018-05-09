package com.gl.sdp.pricecoin.bl;

import com.gl.sdp.pricecoin.dl.Exchange;
import com.gl.sdp.pricecoin.dl.ExchangeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    @Autowired
    ExchangeDao exchangeDao;

    public Exchange findOrCreateExchange(String exchangeName) {
        Exchange exchange = exchangeDao.findByName(exchangeName);
        if ( exchange == null ) {
            exchange = new Exchange();
            exchange.setName(exchangeName);
            exchange = exchangeDao.save(exchange);
        }
        return exchange;
    }
}
