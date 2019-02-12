/**
 * @author yinyunqi
 * @datetime 2018年6月23日
 * @Content 
 */
package com.yongqi.controller.console;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yongqi.model.console.Menu;
import com.yongqi.service.console.MenuService;
import com.yongqi.util.UserInfoUtil;

import io.swagger.annotations.ApiOperation;

@Controller
public class IndexController {
	
	@Autowired
	MenuService menuService;
	
	@ApiOperation(value="跳转Index页面，并返回菜单和用户名",notes="")
	@RequestMapping(value= {"/index","/"},method = RequestMethod.GET)
	public String indexPage(Model model) {
		// 菜单（二级）
		List<Menu> menuList = menuService.menuList();
		model.addAttribute("menuList", menuList);
		String curentUserName = UserInfoUtil.getCurUsername();
		model.addAttribute("curentUserName", curentUserName);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("menuList",menuList);
		return "console/index";
	}
	
}
