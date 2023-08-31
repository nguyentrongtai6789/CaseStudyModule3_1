package service;

import DAO.CategoryDAO;
import model.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryService implements IService<Category>{
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

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
    public List<Category> selectAll(HttpServletRequest req, HttpServletResponse resp) {
        List<Category> categoryList = categoryDAO.selectAll();
        return categoryList;
    }

    @Override
    public Category selectOne(HttpServletRequest req, HttpServletResponse resp) {
        int id_category = Integer.parseInt(req.getParameter("id_category"));
        Category category = categoryDAO.selectOne(id_category);
        return category;
    }
}
