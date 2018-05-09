package com.gl.sdp.pricecoin.dl;

import org.springframework.data.repository.CrudRepository;

public interface ExchangeDao extends CrudRepository<Exchange, Long> {
    Exchange findByName(String name);
}
