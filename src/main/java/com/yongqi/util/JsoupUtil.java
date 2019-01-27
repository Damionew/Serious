/**
 * @author yinyunqi
 * @datetime 2019年1月27日
 * @Content Jsoup爬虫
 */
package com.yongqi.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class JsoupUtil {
	
	public static Document getDocContentByUrl(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc);
		return doc;
	}
}
