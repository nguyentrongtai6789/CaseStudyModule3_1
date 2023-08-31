package DAO;

import connection.MyConnection;
import model.Account;
<<<<<<< HEAD
=======
import model.Blog;
import model.Category;
>>>>>>> 960573b143463020cb734918fbea135b6c545946
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements I_DAO<Account>{
    private static final Long Serial = 1L;
    RoleDAO roleDAO = new RoleDAO();
    private final String SELECT_ACCOUNT ="select * from account";
    private final String INSERT_ACCOUNT ="insert into account(name, username, password, phone, email,address, status, id_role) value(?, ?, ?, ?, ?, ?, ?, ?);";

=======
import java.time.LocalDate;
import java.util.List;

public class AccountDAO implements I_DAO<Account>{
    private static final long serialVersionUID = 1L;
    private static final String SELECT_ACCOUNT_BY_ID = "select * from account where id =?;";
>>>>>>> 960573b143463020cb734918fbea135b6c545946
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
                int idRole = resultSet.getInt(9);
                Role role = roleDAO.selectOne(idRole);
                account = new Account(id,name,username,password,phone,email,address,status,role);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account selectOne(int id_account) {
        Account account = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID)) {
            statement.setInt(1, id_account);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                boolean status = resultSet.getBoolean("status");
//                Role role =
//                LocalDate date = LocalDate.parse(create_at);
//                int id_category = resultSet.getInt("id_category");
//                Category category = categoryDAO.selectOne(id_category);
//                int id_account = resultSet.getInt("id_account");
//                Account account = accountDAO.selectOne(id_account);
//                blog = new Blog(id_select, tittle, content, date, category, account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void insert(Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT)){
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setBoolean(7, account.isStatus());
            preparedStatement.setInt(8, account.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Account account) throws SQLException {

    }
}
