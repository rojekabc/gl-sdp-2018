package com.gl.sdp.pricecoin.sl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CoinEndpoint {
    static final String BASE_PATH = "/api/v1/coin";

    @RequestMapping(
            path = BASE_PATH + "/exchange/{exchange}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void setCoinPrice(
            @PathVariable(name = "exchange") String exchange,
            @RequestBody CoinPriceSO request

    );

    @RequestMapping(
            path = BASE_PATH + "/{coin}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<CoinInfoSO> getCoinPrices(
            @RequestHeader(name = "user") String user,
            @PathVariable(name = "coin") String coin,
            @RequestParam(name = "exchange", required = false) String exchange,
            @RequestParam(name = "asset", required = false) String asset
    );

    @RequestMapping(
            path = BASE_PATH + "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<String> getCoinList();
}
