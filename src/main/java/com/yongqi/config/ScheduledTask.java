package com.yongqi.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yongqi.service.NewsService;

/**
 * 定时任务
 * @author yinyunqi
 *
 */
@Component
public class ScheduledTask {
	@Autowired
	NewsService newsService;
	
	@Scheduled(cron = "0 34 10 * * ?")
	public void taskTest() {
		System.out.println(new Date());
	}
}
