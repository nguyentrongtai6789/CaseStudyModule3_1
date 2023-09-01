package controller;

import DAO.AccountDAO;
import DAO.BlogDAO;
import model.Account;
import model.Blog;
import model.Category;
import model.Img_blog;
import service.AccountService;
import service.BlogService;
import service.CategoryService;
import service.Img_blog_service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "TestServlet", urlPatterns = "/blogs")
public class BlogServlet extends HttpServlet {
    private BlogService blogService;
    private AccountService accountService;
    private CategoryService categoryService;
    private Img_blog_service imgBlogService;

    @Override
    public void init() throws ServletException {
        blogService = new BlogService();
        accountService = new AccountService();
        categoryService = new CategoryService();
        imgBlogService = new Img_blog_service();
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
                case "showBlogByCategory":
                    showBlogByCategory(req, resp);
                    break;
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showBlogByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> blogList = blogService.selectByUser(req, resp); // danh sách blog theo user;
        int id_category = Integer.parseInt(req.getParameter("id_category"));
        // lấy danh sách theo user và category:
        for (Blog blog: blogList) {
            if (blog.getCategory().getId() != id_category) {
                blogList.remove(blog);
            }
        }
        if (blogList.isEmpty()) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("message", "Danh mục bạn chọn không có bài viết nào!!!");
            showListBlogByUser(req, resp);
        } else {
            req.setAttribute("blogList", blogList);// đóng gói để chuyển bị chuyển
            List<Img_blog> imgBlogList = imgBlogService.selectAll(req, resp);
            req.setAttribute("imgBlogList", imgBlogList);
            List<Category> categoryList = categoryService.selectAll(req, resp);
            req.setAttribute("categoryList", categoryList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/lib/formShowListBlogOfUser.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
    private void showListBlogByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> blogList = blogService.selectByUser(req, resp); // lấy ra list blog từ database
        req.setAttribute("blogList", blogList);
        List<Img_blog> imgBlogList = imgBlogService.selectAll(req, resp);
        req.setAttribute("imgBlogList", imgBlogList);
        List<Category> categoryList = categoryService.selectAll(req, resp);
        req.setAttribute("categoryList", categoryList);
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
        String tittle = req.getParameter("tittle");
        String content = req.getParameter("content");
        if (tittle.isEmpty() || content.isEmpty()) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("message", "Bạn nhập thiếu nội dung!!!");
            showFormCreateBlog(req, resp);
        } else {
            blogService.insert(req, resp); // thêm một blog vào database
//        List<Blog> blogList = blogService.selectAll(req, resp);
//        req.setAttribute("blogList", blogList);
            // lưu ảnh lên server:
            saveImgToServer(req, resp);
            // lấy ra danh sách ảnh:
//        List<Img_blog> imgBlogList = imgBlogService.selectAll(req, resp);
//        req.setAttribute("imgBlogList", imgBlogList);
            // alert:
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("message", "Bạn đăng blog thành công!!!");
            showFormCreateBlog(req, resp);
        }
    }

    private void saveImgToServer(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String uploadPath = "D:\\Module3\\CaseStudyModule3\\src\\main\\webapp\\view\\img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Part filePart = req.getPart("url_image");
        String fileName = filePart.getSubmittedFileName();
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
    }
}
