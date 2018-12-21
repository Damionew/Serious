package com.yongqi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yongqi.model.PhotoAlbum;
import com.yongqi.mapper.PhotoMapper;
import com.yongqi.model.Photo;

/**
 * Photo服务处理
 * @author yinyunqi
 *
 */
@Service
public class PhotoService {
	@Autowired
	PhotoMapper photoMapper;
	
	public List<Photo> query_roll() {
		return photoMapper.query_roll();
	}
	
	public List<Photo> query_photo_detail(String album_id) {
		return photoMapper.query_photo_detail(album_id);
	}
	
	public List<Map<String,String>> queryAlbum(){
		// 查询相册
		List<PhotoAlbum> photoAlbumList = photoMapper.query_album();
		// 存放相册信息到Map中
		List<Map<String, String>> albumMap = new ArrayList<Map<String,String>>();
		// 每个相册添加相册封面
		for (PhotoAlbum photoAlbum : photoAlbumList) {
			String photo_url = photoMapper.query_album_cover(photoAlbum.getAlbum_id());
			if (photo_url == null) {
				photo_url = "/images/1.jpg";
			}
			Map<String, String> map = new HashMap<>();
			map.put("photo_url", photo_url);
			map.put("album_name", photoAlbum.getAlbum_name());
			map.put("album_desc", photoAlbum.getAlbum_desc());
			map.put("album_id", String.valueOf(photoAlbum.getAlbum_id()));
			albumMap.add(map);
		}
		return albumMap;
	}
}
