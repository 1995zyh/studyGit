package com.yc.ccs.web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserHandler {
	@RequestMapping("/forget")
	public String forget(String uname,String eamil){
		
		return "";
	}
}
