package com.yongqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;

/**
 * 电影列表
 * @author yinyunqi
 * 2018年12月3日14:47:39
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@GetMapping("")
	@ApiOperation(value="返回movie页面",notes="")
	public String movie() {
		return "movie";
	}
	
	@GetMapping("/movieIframe")
	@ApiOperation(value="返回嵌入在movie中的iframe页面",notes="")
	public String movieIframe() {
		return "movieiframe";
	}
}
