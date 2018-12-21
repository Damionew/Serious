package com.yongqi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yongqi.model.Photo;
import com.yongqi.service.PhotoService;

import io.swagger.annotations.ApiOperation;

/**
 * 新图速递
 * @author yinyunqi
 * 2018年12月21日15:56:18
 */

@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	@RequestMapping("")
	@ApiOperation(value = "跳转相册页面",notes = "加载页面时加载数据库中的Photo")
	public String photoIndex(Model model) {
		
		model.addAttribute("roll", photoService.query_roll());
		model.addAttribute("album",photoService.queryAlbum());
		return "photo/photo";
	}
	
	@RequestMapping("/detail")
	@ApiOperation(value = "跳转相册详细页面",notes = "URL通过album_id指向相册")
	public String photoDetail(String album_id,Model model) {
		List<Photo> photoList = photoService.query_photo_detail(album_id);
		model.addAttribute("photoList", photoList);
		return "photo/photoinfo";
	}
}
