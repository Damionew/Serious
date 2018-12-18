package com.yongqi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yongqi.model.Movie;
import com.yongqi.model.MovieComment;

/**
 * 电影查询接口
 * @author yinyunqi
 * 2018年12月18日15:59:32
 */
@Mapper
public interface MovieMapper {
	
	// 查询所有电影列表
	public List<Movie> queryAllMovieTitle();
	
	// 查询电影详细信息
	public List<Movie> queryMovieInfo(Map<String, String> map);
	
	// 查询电影影评
	public List<MovieComment> queryMovieComment(Map<String, String> map);
}
