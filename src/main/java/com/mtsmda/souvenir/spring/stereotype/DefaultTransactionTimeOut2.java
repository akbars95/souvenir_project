package com.mtsmda.souvenir.spring.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by MTSMDA on 04.07.2016.
 */
public class DefaultTransactionTimeOut2 {

    public Integer small;

    public Integer medium;

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        small = small;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        medium = medium;
    }
}