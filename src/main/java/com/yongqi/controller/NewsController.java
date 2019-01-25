package com.yongqi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yongqi.service.NewsService;

import io.swagger.annotations.ApiOperation;

/**
 * 新闻控制
 * @author yinyunqi
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	NewsService newsService;
	
	@RequestMapping("")
	@ApiOperation(value = "跳转新闻页面",notes = "加载页面时加载数据库中的新闻数据")
	public String newsIndex(Model model) {
		
		return "news/newsIndex";
	}
	
	@ResponseBody
	@RequestMapping("/ana")
	@ApiOperation(value = "解析新闻页面",notes = "解析")
	public void newsAna() throws IOException {
		newsService.jsoupAna();
	}
}
