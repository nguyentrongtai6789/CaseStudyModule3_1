package DAO;

import model.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountDAO implements I_DAO<Account>{
    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public Account selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Account account) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Account account) throws SQLException {

    }
}
