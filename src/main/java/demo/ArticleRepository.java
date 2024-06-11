package demo;

import java.util.ArrayList;

public interface ArticleRepository {
    ArrayList<Article> findAll();
    Article findByUrl(String url);

    default Article save(Article article) {

        return article;
    }

    Article update(Article article);
    void deleteByUrl(String url);
}
