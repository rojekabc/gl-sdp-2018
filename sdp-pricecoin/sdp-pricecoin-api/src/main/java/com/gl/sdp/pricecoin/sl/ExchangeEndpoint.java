package com.gl.sdp.pricecoin.sl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ExchangeEndpoint {
    static final String BASE_PATH = "/api/v1/exchange";

    @RequestMapping(
            path = BASE_PATH + "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<String> listExchanges();

    @RequestMapping(
            path = BASE_PATH + "/{exchange}",
            method = RequestMethod.DELETE
    )
    void removeExchange(
            @PathVariable(name = "exchange") String exchange);

    @RequestMapping(
            path = BASE_PATH + "/{exchange}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<CoinInfoSO> getExchangeData(
            @PathVariable(name = "exchange") String exchange);

}
