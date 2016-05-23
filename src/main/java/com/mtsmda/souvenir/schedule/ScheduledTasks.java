package com.mtsmda.souvenir.schedule;

import com.mtsmda.souvenir.external.ws.ExchangeRateBNMMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dminzat on 5/16/2016.
 */
@Component("scheduledTasks")
public class ScheduledTasks {

    @Autowired
    @Qualifier("exchangeRateBNMMD")
    private ExchangeRateBNMMD exchangeRateBNMMD;

    @Scheduled(cron = "0 0 1 * * MON-FRI")
    public void getExchangeRateFromBNM(){
        String actualRateFromBNM = exchangeRateBNMMD.getActualRateFromBNM();
    }
}