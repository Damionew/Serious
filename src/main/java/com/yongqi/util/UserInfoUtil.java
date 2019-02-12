package com.yongqi.util;

import org.springframework.stereotype.Component;

@Component
public  class UserInfoUtil {
	public static String getCurUsername() {
		String username = "";
//		if (SecurityContextHolder.getContext().getAuthentication() == null) {
//			username = "机器人sa";
//		}else {
//			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
//			username = userDetails.getUsername();
//		}
//		
		username = "机器人sa";
		return username;
	}
}
