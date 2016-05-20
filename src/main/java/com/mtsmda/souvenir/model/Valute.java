package com.mtsmda.souvenir.model;

import com.mtsmda.souvenir.validation.validators.constraints.ValuteCodeConstraint;
import com.mtsmda.souvenir.validation.validators.sequence.FirstSequence;
import com.mtsmda.souvenir.validation.validators.sequence.NotNeedTest;
import com.mtsmda.souvenir.validation.validators.sequence.SecondSequence;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 5/11/2016.
 */
@ValuteCodeConstraint(groups = {NotNeedTest.class}, fieldNameCode = "valuteCode", fieldNameCharCode = "valuteCharCode")
public class Valute implements Serializable{

    private Integer valuteId;

    @NotNull
    @Size(min = 2, max = 50, groups = {FirstSequence.class})
    private String valuteName;

    @NotNull
    private Integer valuteCode;

    @NotNull
    @Size(min = 1, max = 50, groups = {FirstSequence.class})
    private String valuteCharCode;

    @NotNull
    @Min(value = 1, groups = {FirstSequence.class})
    @Max(value = 1000, groups = {SecondSequence.class})
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

    public void setDefaultValuesForFields(){
        this.valuteId = 0;
        this.valuteName = "df";
        this.valuteCode = 0;
        this.valuteCharCode = "mnmnh";
        this.nominal = 1;
    }
}