package edu.feng.trend.config;

import edu.feng.trend.job.IndexDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-11 07:51
 * @version: 1.0
 */

@Configuration
public class QuartzConfiguration {
    // 设置时间间隔为1分钟
    private static final int interval = 50;

    // 在这里新建了一个job 即在job类中定义的IndexDataSyncJob
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(IndexDataSyncJob.class).withIdentity("IndexDataSyncJob").storeDurably().build();
    }

    // 然后在这使用了定时器，指定时长
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(interval).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("indexDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}