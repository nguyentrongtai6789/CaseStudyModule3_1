package service;

import model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AccountService implements IService<Account>{
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public List<Account> selectAll(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public Account selectOne(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
