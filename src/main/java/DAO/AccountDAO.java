package DAO;

import connection.MyConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements I_DAO<Account>{
    private static final Long Serial = 1L;
    private final String SELECT_ACCOUNT ="select * from account";
    private final String INSERT_ACCOUNT ="";

    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Account> selectAll() {
        List<Account> accountList = new ArrayList<>();
        Account account;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String username = resultSet.getString(3);
                String password = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String address = resultSet.getString(7);
                Boolean status = resultSet.getBoolean(8);
                int role = resultSet.getInt(9);
                account = new Account(id,name,username,password,phone,email,address,status,role);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
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
