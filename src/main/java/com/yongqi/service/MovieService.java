package com.yongqi.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yongqi.mapper.MovieMapper;
import com.yongqi.model.Movie;
import com.yongqi.model.MovieComment;
import com.yongqi.util.JsoupUtil;
import com.yongqi.util.UUIDUtil;

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
	@Transactional
	public void jsoupDoubanNewMovie() throws IOException {
		String url = "https://movie.douban.com/chart";
		Document doc = JsoupUtil.getDocContentByUrl(url);
		// 获取包含电影信息的tr
		Elements trEles = doc.select("tr[class=item]");
		for(Element trEle : trEles) {
			Movie movie = new Movie();
			// 电影图片
			String imgUrl = trEle.getElementsByTag("img").attr("src");
			// 获取存放电影信息的div pl2
			Elements pl2 = trEle.select("div[class=pl2]");
			// 电影地址
			String movieUrl = pl2.get(0).getElementsByTag("a").attr("href");
			Elements star = pl2.get(0).getElementsByClass("star clearfix");
			// 评分
			String score =star.get(0).getElementsByClass("rating_nums").text();
			// 评价数
			String commentsamount = star.get(0).getElementsByClass("pl").text();
			movie.setId(UUIDUtil.getUUID());
			movie.setImage(imgUrl);
			movie.setMovieUrl(movieUrl);
			movie.setScore(score);
			movie.setCommentsAmount(commentsamount);
			getMovieDetail(movie);
			// 存储
			movieMapper.saveMovieInfo(movie);
			getMovieReviews(movie);
		}
	}
	/**
	 * 影评
	 * @param map
	 * @throws IOException 
	 */
	private void getMovieReviews(Movie movie) throws IOException {
		String reviewUrl = movie.getMovieUrl()+"comments?status=P"; 
		String moviename = movie.getMovieName();
		Document doc = JsoupUtil.getDocContentByUrl(reviewUrl);
		Elements reviewEles = doc.select("div[class=comment]");
		for (Element element : reviewEles) {
			MovieComment movieComment = new MovieComment();
			Elements infoEles = element.select("span[class=comment-info]");
			String avater = infoEles.get(0).getElementsByTag("a").text();
			String date = infoEles.select("span[class=comment-time]").text();
			String comment = element.select("span[class=short]").text();
			movieComment.setId(UUIDUtil.getUUID());
			movieComment.setAvater(avater);
			movieComment.setMovieName(moviename);
			movieComment.setDate(date);
			movieComment.setComment(comment);
			movieMapper.saveMovieReviews(movieComment);
		}
		
	}

	/**
	 * 电影详细
	 * @param map
	 * @throws IOException
	 */
	private void getMovieDetail(Movie movie) throws IOException {
		String movieUrl = movie.getMovieUrl();
		Document doc = JsoupUtil.getDocContentByUrl(movieUrl);
		Element contentEle = doc.getElementById("content");
		// 影片名称
		String movieName = contentEle.getElementsByTag("h1").text();
		Element infoEle = contentEle.getElementById("info");
		Elements attrsEles = infoEle.select("span[class=attrs]");
		// 导演
		String director = attrsEles.get(0).text();
		// 编剧
		String scenario = attrsEles.get(1).text();
		// 主演
		String staring = attrsEles.get(2).text();
		// 类型
		String movieType = infoEle.select("span[property=v:genre]").text();
		// 上映时间
		String releaseDate = infoEle.select("span[property=v:initialReleaseDate]").text();
		// 片长
		String runtime = infoEle.select("span[property=v:runtime]").text();
		// 剧情简介
		String intro = contentEle.select("span[property=v:summary]").text();
		movie.setMovieName(movieName);
		movie.setDirector(director);
		movie.setScenario(scenario);
		movie.setStaring(staring);
		movie.setMovieType(movieType);
		movie.setReleaseDate(releaseDate);
		movie.setRuntime(runtime);
		movie.setIntro(intro);
	}
	
	/**
	 * 清空表
	 */
	public void truncateMovie() {
		movieMapper.truncateMovieInfo();
		movieMapper.truncateMovieIComment();
	}
}
