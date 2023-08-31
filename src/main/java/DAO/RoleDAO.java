package DAO;

import connection.MyConnection;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements I_DAO<Role>{
    private static final Long Serial = 1L;

    private final String SELECT_ROLE = "select * from role where id = ?";

    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public Role selectOne(int id) {
        Role role = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idValue = resultSet.getInt(1);
                String nameValue = resultSet.getString(2);
                role = new Role(idValue, nameValue);
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
