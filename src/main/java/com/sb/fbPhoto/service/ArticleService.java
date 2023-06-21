package com.sb.fbPhoto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.fbPhoto.dto.Article;
import com.sb.fbPhoto.util.Util;

@Service
public class ArticleService {
	private List<Article> articles;
	private int articleLastId;
	
	public ArticleService() {
		articles = new ArrayList<>();
		articleLastId = 0;
		makeTestData();
	}
	
	public boolean modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);

		if (article == null) {
			return false;
		}
		article.setUpdateDate(Util.getNowDateStr());
		article.setTitle(title);
		article.setBody(body);

		return true;
	}

	public void makeTestData() {
		for (int i = 0; i < 10; i++) {
			writeArticle("제목1", "제목1");
		}

	}

	public boolean deleteArticleById(int id) {
		Article article = getArticleById(id);

		if (article == null) {
			return false;
		}
		articles.remove(article);
		return true;
	}

	public int writeArticle(String title, String body) {
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}
}
