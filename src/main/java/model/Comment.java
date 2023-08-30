package model;

public class Comment {
    private int id;
    private String content;
    private int id_blog;

    public Comment(String content, int id_blog) {
        this.content = content;
        this.id_blog = id_blog;
    }

    public Comment(int id, String content, int id_blog) {
        this.id = id;
        this.content = content;
        this.id_blog = id_blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }
}
