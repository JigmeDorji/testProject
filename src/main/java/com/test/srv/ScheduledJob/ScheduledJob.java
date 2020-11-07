package com.test.srv.ScheduledJob;

import com.test.srv.helper.Scheduler_db_backup;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;

/**
 * Created by vcass on 1/28/2018.
 */
public class ScheduledJob extends QuartzJobBean {

    private Scheduler_db_backup scheduler_db_backup;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            scheduler_db_backup.backupDataDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
