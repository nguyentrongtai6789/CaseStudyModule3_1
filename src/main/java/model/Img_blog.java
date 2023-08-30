package model;

public class Img_blog {
    private int id;
    private String url_image;
    private int id_blog;

    public Img_blog(String url_image, int id_blog) {
        this.url_image = url_image;
        this.id_blog = id_blog;
    }

    public Img_blog(int id, String url_image, int id_blog) {
        this.id = id;
        this.url_image = url_image;
        this.id_blog = id_blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }
}
