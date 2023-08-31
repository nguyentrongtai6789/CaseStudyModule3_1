package controller;

import model.Account;
import service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = null;
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                checkAccount(request, response);
                break;
        }
    }

    public void checkAccount(HttpServletRequest req, HttpServletResponse res){
        Account account = null;
        account = accountService.selectOne(req, res);
        if(account == null){
            try {
                res.sendRedirect("view/lib/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                req.getRequestDispatcher("/home").forward(req,res);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
