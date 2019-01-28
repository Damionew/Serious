package com.yongqi.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void jsoupDoubanNewMovie() throws IOException {
		String url = "https://movie.douban.com/chart";
		Document doc = JsoupUtil.getDocContentByUrl(url);
		// 获取包含电影信息的tr
		Elements trEles = doc.select("tr[class=item]");
		for(Element trEle : trEles) {
			Map<String, String> map = new HashMap<String, String>();
			// 电影图片
			String imgUrl = trEle.getElementsByTag("img").attr("src");
			// 获取存放电影信息的div pl2
			Elements pl2 = trEle.select("div[class=pl2]");
			// 电影地址
			String movieUrl = pl2.get(0).getElementsByTag("a").attr("href");
			Elements star = pl2.get(0).getElementsByClass("star clearfix");
			// 评分
			String rate =star.get(0).getElementsByClass("rating_nums").text();
			// 评价数
			String rateNum = star.get(0).getElementsByClass("pl").text();
			map.put("id", UUIDUtil.getUUID());
			map.put("imgUrl", imgUrl);
			map.put("movieUrl", movieUrl);
			map.put("rate", rate);
			map.put("rateNum", rateNum);
			getMovieDetail(map);
			getMovieReviews(map);
		}
	}
	/**
	 * 影评
	 * @param map
	 * @throws IOException 
	 */
	private void getMovieReviews(Map<String, String> map) throws IOException {
		String reviewUrl = map.get("movieUrl")+"comments?status=P"; 
		String moviename = map.get("moviename");
		Document doc = JsoupUtil.getDocContentByUrl(reviewUrl);
		Elements reviewEles = doc.select("div[class=comment]");
		for (Element element : reviewEles) {
			MovieComment movieComment = new MovieComment();
			Elements infoEles = element.select("span[class=comment-info]");
			String avater = infoEles.get(0).getElementsByTag("a").text();
			String date = infoEles.select("span[class=comment-time]").text();
			String comment = element.select("span[class=short]").text();
			movieComment.setAvater(avater);
			movieComment.setMoviename(moviename);
			movieComment.setDate(date);
			movieComment.setComment(comment);
		}
		
	}

	/**
	 * 电影详细
	 * @param map
	 * @throws IOException
	 */
	private void getMovieDetail(Map<String, String> map) throws IOException {
		String movieUrl = map.get("movieUrl");
		Document doc = JsoupUtil.getDocContentByUrl(movieUrl);
		Element contentEle = doc.getElementById("content");
		// 影片名称
		String moviename = contentEle.getElementsByTag("h1").text();
		Element infoEle = contentEle.getElementById("info");
		Elements attrsEles = infoEle.select("span[class=attrs]");
		// 导演
		String director = attrsEles.get(0).text();
		// 编剧
		String scenario = attrsEles.get(1).text();
		// 主演
		String staring = attrsEles.get(2).text();
		// 类型
		String movietype = infoEle.select("span[property=v:genre]").text();
		// 上映时间
		String releasedate = infoEle.select("span[property=v:initialReleaseDate]").text();
		// 片长
		String runtime = infoEle.select("span[property=v:runtime]").text();
		// 剧情简介
		String intro = contentEle.select("span[property=v:summary]").text();
		map.put("moviename",moviename );
		map.put("director",director );
		map.put("scenario",scenario );
		map.put("staring",staring );
		map.put("movietype",movietype );
		map.put("releasedate",releasedate );
		map.put("runtime",runtime );
		map.put("intro",intro );
	}
}
