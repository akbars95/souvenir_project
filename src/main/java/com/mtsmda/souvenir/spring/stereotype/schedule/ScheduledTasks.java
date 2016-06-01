package com.mtsmda.souvenir.spring.stereotype.schedule;

import com.mtsmda.souvenir.spring.stereotype.ws.ExchangeRateBNMMD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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