package com.mtsmda.souvenir.spring.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by MTSMDA on 04.07.2016.
 */
@Component
public class DefaultTransactionTimeOut {

    @Value("${def.tran.time.out.small}")
    public static Integer small;

    @Value("${def.tran.time.out.medium}")
    public static Integer medium;

    public static void setSmall(Integer small) {
        DefaultTransactionTimeOut.small = small;
    }

    public static void setMedium(Integer medium) {
        DefaultTransactionTimeOut.medium = medium;
    }
}