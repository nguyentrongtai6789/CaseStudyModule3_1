package model;

import java.time.LocalDate;

public class Blog {
    private int id;
    private String title;
    private String content;
    private LocalDate create_at;
    private Category category;
    private Account account;

    public Blog(String title, String content, LocalDate create_at, Category category,
                Account account) {
        this.title = title;
        this.content = content;
        this.create_at = create_at;
        this.category = category;
        this.account = account;
    }

    public Blog(int id, String title, String content, LocalDate create_at,
                Category category, Account account) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_at = create_at;
        this.category = category;
        this.account = account;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
