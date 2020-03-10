package com.example.springschedule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author z.Taghizadeh
 */
@Configuration
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class ScheduleEnabling {

    @Scheduled(fixedRate = 1000) // or @Scheduled(fixedRateString = "${sample.schedule.string}")
    public void scheduleTaskWithFixedRate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 3000) // or @Scheduled(fixedDelayString = "${sample.schedule.string}", initialDelayString="${sample.schedule.initial.string}")
    public void scheduleTaskWithFixedDelay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Delay scheduler:: " + strDate);
    }

    @Scheduled(cron = "*/5 * * * * ?") //or @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskWithCron() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

}
