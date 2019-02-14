/**
 * @author yinyunqi
 * @datetime 2019年2月14日
 * @Content 
 */
package com.yongqi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yongqi.model.News;

@Mapper
public interface NewsMapper {
	
	// 存储电影信息
	public void saveNews(News news);
}
