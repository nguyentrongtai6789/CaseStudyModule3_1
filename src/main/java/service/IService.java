package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IService<E> {
    void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void update(HttpServletRequest req, HttpServletResponse resp);
    void delete(HttpServletRequest req, HttpServletResponse resp);
    List<E> selectAll(HttpServletRequest req, HttpServletResponse resp);
    E selectOne(HttpServletRequest req, HttpServletResponse resp);
}
