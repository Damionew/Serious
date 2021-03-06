package com.yongqi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yongqi.model.Movie;
import com.yongqi.service.MovieService;

import io.swagger.annotations.ApiOperation;

/**
 * 新片影评
 * @author yinyunqi
 * 2018年12月3日14:47:39
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("")
	@ApiOperation(value="返回movie页面",notes="")
	public String movie(Model model) {
		List<Movie> movieList = movieService.getAllMovieTitle();
		// 默认第一个movie
		String defaultMoviename = movieList.get(0).getMovieName();
		model.addAttribute(movieList);
		model.addAttribute("defaultMovieName",defaultMoviename);
		return "movie/movieIndex";
	}
	
	@GetMapping("/movieIframe")
	@ApiOperation(value="返回嵌入在movie中的iframe页面",notes="")
	public String movieIframe(Model model,@RequestParam("movieName") String movieName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("movieName", movieName);
		Movie movie = movieService.getMovieInfo(map);
		model.addAttribute(movie);
		return "movie/movieInfo";
	}
	
	@ResponseBody
	@GetMapping("/jsoupDoubanNewMovie")
	@ApiOperation(value="返回嵌入在movie中的iframe页面",notes="")
	public void jsoupDoubanNewMovie() throws IOException {
		movieService.jsoupDoubanNewMovie();
	}
}
