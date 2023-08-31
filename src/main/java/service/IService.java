package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService<E> {
    void insert(HttpServletRequest req, HttpServletResponse resp);
    void update(HttpServletRequest req, HttpServletResponse resp);
    void delete(HttpServletRequest req, HttpServletResponse resp);
    void selectAll(HttpServletRequest req, HttpServletResponse resp);
    void selectOne(HttpServletRequest req, HttpServletResponse resp);
}
