package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MyArticleService implements ArticleService{
    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>(); // Collections chứa những phần tử với giá trị unique
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String href = element.attr("href");
                if(href.contains("https://vnexpress.net") && href.contains(".html")){
                    links.add(href);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(links);
    }

    @Override
    public Article getArticle(String url) {
        // Document - DOM
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            // selector: id, class, tag, mixed (combine) selector
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String firstImageLink = doc.select("picture img[itemprop=contentUrl]").attr("data-src");
            String authorName = doc.select("article.fck_detail p.Normal[style=text-align:right;]").text();
            Article article = new Article();
            article.setTitle(title); //...
            article.setDescription(description);
            article.setCreatedAt("2000-10-10");
            article.getBaseUrl();
            article.getContent();
            article.getStatus(1);

            return article;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}