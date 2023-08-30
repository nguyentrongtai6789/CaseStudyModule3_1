package model;

import java.time.LocalDate;

public class Blog {
    private int id;
    private String title;
    private String content;
    private LocalDate create_at;
    private int id_category;
    private int id_account;

    public Blog(String title, String content, LocalDate create_at, int id_category,
                int id_account) {
        this.title = title;
        this.content = content;
        this.create_at = create_at;
        this.id_category = id_category;
        this.id_account = id_account;
    }

    public Blog(int id, String title, String content, LocalDate create_at,
                int id_category, int id_account) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_at = create_at;
        this.id_category = id_category;
        this.id_account = id_account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }
}
