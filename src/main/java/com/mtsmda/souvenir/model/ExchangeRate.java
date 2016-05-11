package com.mtsmda.souvenir.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dminzat on 5/11/2016.
 */
public class ExchangeRate implements Serializable {

    private Integer exchangeRateId;
    private LocalDate exchangeRateDate;
    private Valute valuteName;
    private Double exchangeRate;

    public ExchangeRate() {

    }

    public Integer getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public LocalDate getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(LocalDate exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public Valute getValuteName() {
        return valuteName;
    }

    public void setValuteName(Valute valuteName) {
        this.valuteName = valuteName;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}