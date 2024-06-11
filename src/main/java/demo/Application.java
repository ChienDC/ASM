package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ArticleService articleService = new VnexpressArticleService();
        ArrayList<String> links = articleService.getLinks("https://vnexpress.net/tam-su");
        for (int i = 0; i < links.size(); i++) {
            Article article = articleService.getArticle(links.get(i));
            System.out.printf("%d - %s\n", i + 1, article.getTitle());

            ArticleController articleController = new ArticleController();
            articleController.creatAndSave();
        }
    }
}
//    public static void main(String[] args) {}
//    public static void generateMenu() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("1. Crawl thông tin từ vnexpress.");
//            System.out.println("2. Crawl thông tin từ nguồn của tôi.");
//            System.out.println("3. Hiển thị danh sách tin hiện có.");
//            System.out.println("4. Thoát chương trình.");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//
//        }
//    }

//    private static void displayArticles() {
//    }
//}