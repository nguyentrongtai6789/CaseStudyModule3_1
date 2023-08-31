package service;

import DAO.AccountDAO;
import DAO.RoleDAO;
import model.Account;
import model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AccountService implements IService<Account>{
    AccountDAO accountDAO = new AccountDAO();
    RoleDAO roleDAO = new RoleDAO();
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String passwork = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        boolean status = true;
        int idRole = 1;
        Role role = roleDAO.selectOne(idRole);
        Account account = new Account(name, username, passwork, phoneNumber, email, address, status, role);
        accountDAO.insert(account);
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public List<Account> selectAll(HttpServletRequest req, HttpServletResponse resp) {return null;}

    @Override
    public Account selectOne(HttpServletRequest req, HttpServletResponse resp) {
        List<Account> accounts = accountDAO.selectAll();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        for(Account account : accounts){
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }
}
