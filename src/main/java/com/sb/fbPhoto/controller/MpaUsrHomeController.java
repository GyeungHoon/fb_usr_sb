package com.sb.fbPhoto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MpaUsrHomeController {
	@RequestMapping("/mpaUsr/Home/main")
	@ResponseBody
	public String showMain() {
		return "안녕";
	}
}
