package com.mtsmda.souvenir.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dminzat on 5/11/2016.
 */
@XmlRootElement(name = "Valute")
public class Valute {

    private Integer valuteId;

    private Integer numCode;

    private String charCode;

    private Integer nominal;

    private String name;

    private Double value;

    public Valute() {

    }

    public Integer getValuteId() {
        return valuteId;
    }

    @XmlAttribute(name = "ID")
    public void setValuteId(Integer valuteId) {
        this.valuteId = valuteId;
    }

    public Integer getNumCode() {
        return numCode;
    }

    @XmlElement(name = "NumCode")
    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    @XmlElement(name = "CharCode")
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    @XmlElement(name = "Nominal")
    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    @XmlElement(name = "Value")
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Valute valute = (Valute) o;

        if (!valuteId.equals(valute.valuteId)) return false;
        if (!numCode.equals(valute.numCode)) return false;
        if (!charCode.equals(valute.charCode)) return false;
        if (!nominal.equals(valute.nominal)) return false;
        if (!name.equals(valute.name)) return false;
        return value.equals(valute.value);

    }

    @Override
    public int hashCode() {
        int result = valuteId.hashCode();
        result = 31 * result + numCode.hashCode();
        result = 31 * result + charCode.hashCode();
        result = 31 * result + nominal.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
