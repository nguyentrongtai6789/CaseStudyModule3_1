package service;

import DAO.AccountDAO;
import DAO.BlogDAO;
import DAO.CategoryDAO;
import DAO.ImgDAO;
import model.Account;
import model.Blog;
import model.Category;
import model.Img_blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlogService implements IService<Blog> {
    private BlogDAO blogDAO;
    private ImgDAO imgDAO;
    private CategoryDAO categoryDAO;
    private AccountDAO accountDAO;

    public BlogService() {
        blogDAO = new BlogDAO();
        imgDAO = new ImgDAO();
        categoryDAO = new CategoryDAO();
        accountDAO = new AccountDAO();
    }
    public List<Blog> selectByUser(HttpServletRequest req, HttpServletResponse resp) {
        int id_account = Integer.parseInt(req.getParameter("id_account"));
        List<Blog> blogList = blogDAO.selectByUser(id_account);
        return blogList;
    }
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        String tittle = req.getParameter("tittle");
        String content = req.getParameter("content");
        LocalDate create_at = LocalDate.parse(req.getParameter("create_at"));
        int id_category = Integer.parseInt(req.getParameter("id_category"));
        Category category = categoryDAO.selectOne(id_category);
        int id_account = Integer.parseInt(req.getParameter("id_account"));
        Account account = accountDAO.selectOne(id_account);
        Blog blog = new Blog(tittle, content, create_at, category, account);
        blogDAO.insert(blog); // thêm một blog vào database
        int id_blog = blogDAO.selectMaxId(); // lấy ra id max để tạo đối tượng img
        String urlImg = req.getParameter("url_image");
        Img_blog imgBlog = new Img_blog(urlImg, id_blog);
        imgDAO.insert(imgBlog); // thêm ảnh vào database
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public List<Blog> selectAll(HttpServletRequest req, HttpServletResponse resp) {
        List<Blog> blogList = blogDAO.selectAll();
        return blogList;
    }

    @Override
    public Blog selectOne(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
