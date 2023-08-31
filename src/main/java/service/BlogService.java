package service;

import DAO.BlogDAO;
import model.Blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class BlogService implements IService<Blog>{
    private BlogDAO blogDAO;

    public BlogService() {
        blogDAO =  new BlogDAO();
    }

    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        String tittle = req.getParameter("tittle");
        String content = req.getParameter("content");
        LocalDate create_at = LocalDate.parse(req.getParameter("create_at"));
        int id_category = Integer.parseInt(req.getParameter("id_category"));
        int id_account = Integer.parseInt(req.getParameter("id_account"));
        Blog blog = new Blog(tittle, content, create_at, id_category, id_account);
        blogDAO.insert(blog);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void selectOne(HttpServletRequest req, HttpServletResponse resp) {

    }

}
