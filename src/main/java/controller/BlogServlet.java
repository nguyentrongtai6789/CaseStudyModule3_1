package controller;

import DAO.AccountDAO;
import DAO.BlogDAO;
import model.Account;
import model.Blog;
import model.Category;
import service.AccountService;
import service.BlogService;
import service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/blogs")
public class BlogServlet extends HttpServlet {
    private BlogService blogService;
    private AccountService accountService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        blogService = new BlogService();
        accountService = new AccountService();
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "showFormCreateBlog":
                    showFormCreateBlog(req, resp);
                    break;
                case "showListBlogByUser":
                    showListBlogByUser(req, resp);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
    private void showListBlogByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> blogList = blogService.selectByUser(req, resp); // lấy ra list blog từ database
        req.setAttribute("blogList", blogList); // đóng gói để chuyển bị chuyển
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/lib/formShowListBlogOfUser.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showFormCreateBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryService.selectAll(req, resp);
        req.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/lib/formCreateBlog.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createBlog":
                createBlog(req, resp);
                break;

        }
    }

    private void createBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        blogService.insert(req, resp); // thêm một blog vào database
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("message", "Bạn đăng blog thành công!!!");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/lib/formCreateBlog.jsp");
        requestDispatcher.forward(req, resp);
    }
}
