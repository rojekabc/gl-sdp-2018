package com.gl.sdp.pricecoin.sl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ExchangeEndpointImpl implements ExchangeEndpoint {
    @Override
    public List<String> listExchanges() {
        return null;
    }

    @Override
    public void removeExchange(@PathVariable(name = "exchange") String exchange) {

    }

    @Override
    public List<CoinInfoSO> getExchangeData(@PathVariable(name = "exchange") String exchange) {
        return null;
    }
}
