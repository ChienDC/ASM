package demo;

import java.sql.*;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository{
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/asm";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";
    @Override
    public ArrayList<Article> findAll() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM article");
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setBaseUrl(rs.getString("baseUrl"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setContent(rs.getString("content"));
                article.setThumbnail(rs.getString("thumbnail"));
                article.setCreatedAt(rs.getString("createdAt"));
                article.setUpdateAt(rs.getString("updatedAt"));
                article.setDeleteAt(rs.getString("deletedAt"));
                article.setStatus(rs.getInt("status"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }


    @Override
    public Article findByUrl(String url) {
        Article article = null;
        try (Connection conn = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM article WHERE baseUrl = ?")) {
            pstmt.setString(1, url);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setBaseUrl(rs.getString("baseUrl"));
                article.setTitle(rs.getString("title"));
                article.setDescription(rs.getString("description"));
                article.setContent(rs.getString("content"));
                article.setThumbnail(rs.getString("thumbnail"));
                article.setCreatedAt(rs.getString("createdAt"));
                article.setUpdateAt(rs.getString("updatedAt"));
                article.setDeleteAt(rs.getString("deletedAt"));
                article.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article save(Article article) {
        try (Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            String prepareSql = "INSERT INTO article"+ "(baseUrl, title, description, content, thumbnail, createdAt, updatedAt, deletedAt, status)"+ "VALUES" +"(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getThumbnail());
            preparedStatement.setString(6, article.getCreateAt().toString());
            preparedStatement.setString(7, article.getUpdateAt().toString());
            preparedStatement.setString(8, article.getDeleteAt().toString());
            preparedStatement.setInt(9, article.getStatus(1));
            preparedStatement.executeUpdate();
            System.out.println("Add new success");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error adding new order");
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prepareSql = "insert into article " + "(baseUrl, title, description, content, thumbnail, createAt, updateAt, deleteAt, status) " + "values " + "(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getThumbnail());
            preparedStatement.setString(6, article.getCreateAt().toString());
            preparedStatement.setString(7, article.getUpdateAt().toString());
            preparedStatement.setString(8, article.getDeleteAt().toString());
            preparedStatement.setInt(9, article.getStatus(1));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public void deleteByUrl(String url) {
        try (Connection conn = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD); PreparedStatement pstmt = conn.prepareStatement("DELETE FROM articles WHERE baseUrl = ?")) {
            pstmt.setString(1, url);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
