package com.yongqi.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * 新闻处理类
 * @author yinyunqi
 * 2018年12月18日16:11:53
 */

@Service
public class NewsService {
	
	/**
	 * 使用JSoup解析网页信息
	 * @throws IOException 
	 */
	public void jsoupAna() throws IOException {
		Document doc = Jsoup.connect("https://news.163.com/")
				// 模拟谷歌
				.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
				.get();
		Elements elements = doc.select("div#newsdata_list noloading").first().getElementsByClass("ndi_main");
		System.out.println(elements);
	}
}
