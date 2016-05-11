package com.mtsmda.souvenir.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 5/11/2016.
 */
public class Valute implements Serializable{

    private Integer valuteId;
    private String valuteName;
    private Integer valuteCode;
    private String valuteCharCode;
    private Integer nominal;
    private List<ExchangeRate> exchangeRates = new ArrayList<>();

    public Valute() {

    }

    public Integer getValuteId() {
        return valuteId;
    }

    public void setValuteId(Integer valuteId) {
        this.valuteId = valuteId;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public Integer getValuteCode() {
        return valuteCode;
    }

    public void setValuteCode(Integer valuteCode) {
        this.valuteCode = valuteCode;
    }

    public String getValuteCharCode() {
        return valuteCharCode;
    }

    public void setValuteCharCode(String valuteCharCode) {
        this.valuteCharCode = valuteCharCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}