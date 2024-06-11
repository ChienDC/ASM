package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class ThreadMain {


    // 10 links: 2,6 s
    public static void main(String[] args) {
        HashSet<String> links = new HashSet<>();
        links.addAll(getLinks("https://vnexpress.net/the-thao"));
        links.addAll(getLinks("https://vnexpress.net/suc-khoe"));
        links.addAll(getLinks("https://vnexpress.net/doi-song"));
        links.addAll(getLinks("https://vnexpress.net/tam-su"));
        links.addAll(getLinks("https://vnexpress.net/du-lich"));
        System.out.println(links.size());
        for (String link : links) {
            getContent(link);
        }
    }

    public static HashSet<String> getLinks(String indexUrl) {
        HashSet<String> links = new HashSet<>(); // Collections chứa những phần tử với giá trị unique
        try {
            Document document = Jsoup.connect(indexUrl).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href.contains("https://vnexpress.net") && href.contains(".html")) {
                    links.add(href);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return links;
    }

    public static void getContent(String url) {
        // Document - DOM
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            // selector: id, class, tag, mixed (combine) selector
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String firstImageLink = doc.select("picture img[itemprop=contentUrl]").attr("data-src");
            String authorName = doc.select("article.fck_detail p.Normal[style=text-align:right;]").text();
            System.out.println(title);
            System.out.println(description);
            System.out.println(firstImageLink);
            System.out.println(authorName);
            System.out.println("-------------------------------");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
