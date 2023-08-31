package DAO;

import model.Comment;

import java.sql.SQLException;
import java.util.List;

public class CommentDAO implements I_DAO<Comment>{
    @Override
    public List<Comment> selectAll() {
        return null;
    }

    @Override
    public Comment selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Comment comment) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Comment comment) throws SQLException {

    }
}
