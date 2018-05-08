package com.gl.sdp.pricecoin.dl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Exchange implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    /** The exchange identifier in the system. */
    @Column
    private String name;

    /** The list of prices registered by the exchange. */
    @OneToMany
    private List<CoinPrice> prices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CoinPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<CoinPrice> prices) {
        this.prices = prices;
    }
}
