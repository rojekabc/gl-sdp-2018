package com.gl.sdp.pricecoin.dl;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class CoinPrice implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /** Coin symbol. */
    @Column
    private String coin;

    /** Asset coin symbol. */
    @Column
    private String assetCoint;

    /** Quantity of asset coin exchanged to one coin. */
    @Column
    private BigDecimal quantity;

    /** The exchange, which register price. */
    @ManyToOne
    private Exchange exchange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAssetCoint() {
        return assetCoint;
    }

    public void setAssetCoint(String assetCoint) {
        this.assetCoint = assetCoint;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
