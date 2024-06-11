package demo;

public class Article {
    private int id;
    private String baseUrl;
    private String title;
    private String description;
    private String content;
    private String thumbnail;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private int status;

    public String toString() {
        return "article{" +
                "id=" + id +
                ", baseUrl='" + baseUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", createAt=" + createdAt +
                ", updateAt=" + updatedAt +
                ", deleteAt=" + deletedAt +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(String createAt) {
        this.createdAt = createAt;
    }

    public String getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updatedAt = updateAt;
    }

    public String getDeleteAt() {
        return deletedAt;
    }

    public void setDeleteAt(String deleteAt) {
        this.deletedAt = deleteAt;
    }

    public int getStatus(int i) {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreatedAt(String date) {
    }
}
