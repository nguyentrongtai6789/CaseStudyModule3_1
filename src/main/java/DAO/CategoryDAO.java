package DAO;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements I_DAO<Category>{
    @Override
    public List<Category> selectAll() {
        return null;
    }

    @Override
    public Category selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Category category) throws SQLException {

    }
}
