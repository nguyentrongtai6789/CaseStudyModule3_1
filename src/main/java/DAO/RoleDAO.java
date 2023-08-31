package DAO;

import model.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements I_DAO<Role>{
    @Override
    public List<Role> selectAll() {
        return null;
    }

    @Override
    public Role selectOne(int id) {
        return null;
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
