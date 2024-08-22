package org.example.article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    static List<Article> articleList = new ArrayList<>();
    int lastId = 1;
    public int create (String subject, String content) {
        Article article = new Article(lastId, subject, content);
        articleList.add(article);

        lastId++;

        return article.getId();
    }

    public static List<Article> findAll() {
        return articleList;
    }

    public static Article getFindById(int id) {
        for (Article item : articleList) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void remove(Article article) {
        articleList.remove(article);
    }
}