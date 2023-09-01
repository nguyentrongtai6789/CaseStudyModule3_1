package DAO;

import connection.MyConnection;
import model.Account;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements I_DAO<Role>{
    private static final long serialVersionUID = 1L;
    private static final String SELECT_ROLE_BY_ID = "select * from ROLE where id =?;";
    private final Connection connection = MyConnection.getInstance();


    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public Role selectOne(int id_role) {
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ROLE_BY_ID)) {
            statement.setInt(1, id_role);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("role_name");
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void insert(Role role) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Role role) throws SQLException {

    }
}
