package edu.feng.trend.job;

import cn.hutool.core.date.DateUtil;
import edu.feng.trend.pojo.Index;
import edu.feng.trend.service.IndexDataService;
import edu.feng.trend.service.IndexService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @program: trendParentProject
 * @description: 任务类，同时刷新指数代码和指数数据。
 * @author: feng
 * @create: 2020-05-11 07:46
 * @version: 1.0
 */
public class IndexDataSyncJob extends QuartzJobBean {
    @Autowired
    private IndexService indexService;
    @Autowired
    private IndexDataService indexDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时启动：" + DateUtil.now());
        List<Index> indexes = indexService.fresh();
        for (Index index : indexes) {
            indexDataService.fresh(index.getCode());
        }
        System.out.println("定时结束：" + DateUtil.now());
    }
}