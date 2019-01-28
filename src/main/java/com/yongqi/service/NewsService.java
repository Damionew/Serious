package com.yongqi.service;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongqi.util.JsoupUtil;

/**
 * 新闻处理类
 * @author yinyunqi
 * 2018年12月18日16:11:53
 */

@Service
public class NewsService {
	@Autowired
	JsoupUtil jsoupUtil;
	/**
	 * 使用JSoup解析网页信息
	 * @throws IOException 
	 */
	public void jsoupAna() throws IOException {
		String url = "https://movie.douban.com/chart";
		Document doc = jsoupUtil.getDocContentByUrl(url);
//		Elements elements = doc.select("div#newsdata_list noloading").first().getElementsByClass("ndi_main");
		System.out.println(doc);
	}
}
