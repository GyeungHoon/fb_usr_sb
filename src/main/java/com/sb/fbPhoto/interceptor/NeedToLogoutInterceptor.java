package com.sb.fbPhoto.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sb.fbPhoto.dto.Member;
import com.sb.fbPhoto.dto.Rq;
import com.sb.fbPhoto.service.MemberService;
import com.sb.fbPhoto.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NeedToLogoutInterceptor implements HandlerInterceptor {
	@Autowired
	private MemberService memberService;
	
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
    	
    	Rq rq = (Rq)req.getAttribute("rq");

    	if(rq.isLogined()) {
    		resp.setContentType("text/html; charset=UTF-8");
    		resp.getWriter().append(Util.msgAndBack("로그아웃 후 이용해주세요"));
    		return false;
    	}
        return HandlerInterceptor.super.preHandle(req, resp, handler);
    }
}