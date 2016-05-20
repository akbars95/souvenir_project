package com.mtsmda.souvenir.valute;

import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by dminzat on 5/17/2016.
 */
public class ValuteBorder {

    private Properties valuteProperties;

    public Properties getValuteProperties() {
        return valuteProperties;
    }

    public void setValuteProperties(Properties valuteProperties) {
        this.valuteProperties = valuteProperties;
    }
}