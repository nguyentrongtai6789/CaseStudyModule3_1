package controller;

import model.Account;
import model.Blog;
import service.AccountService;
import service.BlogService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TestServlet", urlPatterns = "/blogs")
public class BlogServlet extends HttpServlet {
    private BlogService blogService;
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        blogService = new BlogService();
        accountService = new AccountService();
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

            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void showFormCreateBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_account = Integer.parseInt(req.getParameter("id_account"));
        Account account = accountService.selectOne(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/formCreateBlog.jsp");
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

    private void createBlog(HttpServletRequest req, HttpServletResponse resp) {
        blogService.insert(req, resp);
    }
}
