package com.yc.ccs.seb.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/user")
@Controller
public class UserHandler {
	
/*	@Autowired
	private UserService	 userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public boolean doLogin(User user,HttpSession session){
		LogManager.getLogger().debug("请求UserHandler处理login...");
		user=userService.login(user);
		session.setAttribute("loginUser", user);
		return user!=null;
	}
	*/
}
