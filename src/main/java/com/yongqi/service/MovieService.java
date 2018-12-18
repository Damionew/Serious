package com.yongqi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongqi.mapper.MovieMapper;
import com.yongqi.model.Movie;

/**
 * 电影信息处理类
 * @author yinyunqi
 * 2018年12月18日16:11:53
 */

@Service
public class MovieService {
	@Autowired
	MovieMapper movieMapper;
	
	/**
	 * 查询所有电影标题
	 * @return
	 */
	public List<Movie> getAllMovieTitle() {
		return movieMapper.queryAllMovieTitle();
	}
	
}
