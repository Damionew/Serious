package com.yongqi.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yongqi.service.MovieService;

/**
 * 定时任务
 * @author yinyunqi
 *
 */
@Component
public class ScheduledTask {
	@Autowired
	MovieService movieService;
	
	/**
	 * 更新新片榜
	 * @throws IOException 
	 */
	@Scheduled(cron = "0 22 10 * * ?")
	public void jsoupDoubanNewMovie() throws IOException {
		// 先删后插
		movieService.truncateMovie();
		movieService.jsoupDoubanNewMovie();
	}
}
