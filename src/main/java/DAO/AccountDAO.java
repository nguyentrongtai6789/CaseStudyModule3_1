package DAO;

import connection.MyConnection;
import model.Account;
import model.Blog;
import model.Category;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AccountDAO implements I_DAO<Account>{
    private static final long serialVersionUID = 1L;
    private static final String SELECT_ACCOUNT_BY_ID = "select * from account where id =?;";
    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Account> selectAll() {
        return null;
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

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Account account) throws SQLException {

    }
}
