package com.sb.fbPhoto.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sb.fbPhoto.util.Util;

@Controller
public class MpaUsrMemberController {

	@RequestMapping("/mpaUsr/member/join")
	public String showJoin(HttpServletRequest req) {
		return "mpaUsr/member/join";
	}
	
	@RequestMapping("/mpaUsr/member/doJoin")
	@ResponseBody
	public Map doJoin(String loginId, String loginPw, String nmae, String nickname, String cellphonNo, String email) {
		
		return Util.mapOf("loginId",loginId,"loginPw",loginPw);
		
	}

}
