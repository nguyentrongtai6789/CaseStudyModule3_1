package service;

import model.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommentService implements IService<Comment>{
    @Override
    public void insert(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public List<Comment> selectAll(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public Comment selectOne(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
