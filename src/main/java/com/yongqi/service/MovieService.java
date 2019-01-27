package com.yongqi.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongqi.mapper.MovieMapper;
import com.yongqi.model.Movie;
import com.yongqi.util.JsoupUtil;

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
	
	/**
	 * 查询电影信息
	 * @return
	 */
	public Movie getMovieInfo(Map<String, String> map) {
		Movie movieInfo = movieMapper.queryMovieInfo(map);
		movieInfo.setMovieComments(movieMapper.queryMovieComment(map));
		return movieInfo;
	}
	
	/**
	 * 爬取豆瓣电影排行榜
	 * @throws IOException 
	 */
	public void jsoupDoubanNewMovie() throws IOException {
		String url = "https://movie.douban.com/chart";
		Document doc = JsoupUtil.getDocContentByUrl(url);
		String title = doc.title();
		Elements tr = doc.select("tr[class=item]");
		System.out.println(title);
	}
}
