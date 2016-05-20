package com.mtsmda.souvenir.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 5/16/2016.
 */
@EnableScheduling
@Component
public class RunScheduling {

    @Autowired
    private ScheduledTasks scheduledTasks;

}