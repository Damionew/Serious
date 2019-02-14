package com.yongqi.service;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongqi.mapper.NewsMapper;
import com.yongqi.model.News;
import com.yongqi.util.JsoupUtil;
import com.yongqi.util.UUIDUtil;

/**
 * 新闻处理类
 * @author yinyunqi
 * 2018年12月18日16:11:53
 */

@Service
public class NewsService {
	@Autowired
	NewsMapper newsMapper;
	/**
	 * 使用JSoup解析网页信息
	 * @throws IOException 
	 */
	public void jsoupAna() throws IOException {
		String url = "http://news.zol.com.cn/";
		Document doc = JsoupUtil.getDocContentByUrl(url);
		Elements liEles = doc.select("li[class=content-list-item]");
		for(Element liEle : liEles) {
			News news = new News();
			Elements infoModEles = liEle.select("div[class=info-mod clearfix]");
			String newsUrl = infoModEles.get(0).getElementsByTag("a").attr("href");
			String newsImg = infoModEles.get(0).getElementsByTag("img").attr(".src");
			Elements infoHeadEles = liEle.select("div[class=info-head]");
			String newsTitle = infoHeadEles.get(0).getElementsByTag("a").attr("href");
			String pDesc = liEle.select("p").text();
			String aDec = liEle.select("p").select("a").text();
			String newsDesc = pDesc.replaceAll(aDec,"").replaceAll("\\[]","");
			news.setId(UUIDUtil.getUUID());
			news.setNewsUrl(newsUrl);
			news.setNewsTitle(newsTitle);
			news.setNewsSource("zol");
			news.setNewsImg(newsImg);
			news.setNewsDesc(newsDesc);
			newsMapper.saveNews(news);
		}
	}
}
