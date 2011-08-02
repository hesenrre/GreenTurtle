package com.jwm.greenturtle.cron;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jwm.greenturtle.fast.content.Eraser;

public class GreenTurtleJob implements Job{

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		JobDataMap map = ctx.getJobDetail().getJobDataMap();
		Eraser.delete(map.getString("query"), map.getString("searchview"),
				map.getString("searchServer"), map.getString("contentDist"));
	}

}