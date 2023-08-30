package DAO;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO extends I_DAO<Blog>{
    @Override
    List<Blog> selectAll();

    @Override
    Blog selectOne(int id);

    @Override
    void insert(Blog blog);

    @Override
    void delete(int id) throws SQLException;

    @Override
    void update(Blog blog) throws SQLException;
}
