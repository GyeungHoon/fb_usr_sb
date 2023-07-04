package com.sb.fbPhoto.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.fbPhoto.dao.ReplyDao;

@Service
public class Reply {
    @Autowired
    private ReplyDao replyDao;

    public ResultData write(String relTypeCode, int relId, int memberId, String body) {
        replyDao.write(relTypeCode, relId, memberId, body);
        int id = replyDao.getLastInsertId();

        return new ResultData("S-1", "댓글이 작성되었습니다.", "id", id);
    }
}