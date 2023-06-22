package com.sb.fbPhoto.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.sb.fbPhoto.dto.Article;

@Component
public interface ArticleDao {

	boolean modifyArticle(@Param("id")int id, @Param("title")String title, @Param("body")String body);
	void writeArticle(@Param("boardId")int boardId, @Param("memberId")int memberId, @Param("title")String title, @Param("body")String body);
	Article getArticleById(@Param("id")int id);
	void deleteArticleById(@Param("id")int id);

}
