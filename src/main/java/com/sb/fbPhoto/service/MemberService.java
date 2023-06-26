package com.sb.fbPhoto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.fbPhoto.dao.MemberDao;
import com.sb.fbPhoto.dto.Member;
import com.sb.fbPhoto.dto.ResultData;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public Member getMemberByLoginId(String loginId) {
        return memberDao.getMemberByLoginId(loginId);
    }

    public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
        memberDao.join(loginId, loginPw, name, nickname, cellphoneNo, email);
        int id = memberDao.getLastInsertId();

        return new ResultData("S-1", "회원가입이 완료되었습니다.", "id", id);
    }
}
