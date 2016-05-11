package com.mtsmda.souvenir.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dminzat on 5/11/2016.
 */
@XmlRootElement(name = "ValCurs")
public class ValCurs {

    private String date;

    private String name;

    private List<Valute> valutes = new ArrayList<>();

    public ValCurs() {

    }

    public String getDate() {
        return date;
    }

    @XmlAttribute(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public List<Valute> getValutes() {
        return valutes;
    }

    @XmlElement(name = "Valute")
    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValCurs valCurs = (ValCurs) o;

        if (!date.equals(valCurs.date)) return false;
        if (!name.equals(valCurs.name)) return false;
        return valutes != null ? valutes.equals(valCurs.valutes) : valCurs.valutes == null;

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (valutes != null ? valutes.hashCode() : 0);
        return result;
    }

}