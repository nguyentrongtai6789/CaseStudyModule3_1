package service;

import DAO.ImgDAO;
import model.Img_blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Img_blog_service implements IService<Img_blog>{
    private ImgDAO imgDAO;

    public Img_blog_service() {
        imgDAO = new ImgDAO();
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
    public List<Img_blog> selectAll(HttpServletRequest req, HttpServletResponse resp) {
        List<Img_blog> imgBlogList = imgDAO.selectAll();
        return imgBlogList;
    }

    @Override
    public Img_blog selectOne(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
