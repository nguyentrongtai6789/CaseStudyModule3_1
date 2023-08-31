package DAO;

import model.Img_blog;

import java.sql.SQLException;
import java.util.List;

public class ImgDAO implements I_DAO<Img_blog>{
    @Override
    public List<Img_blog> selectAll() {
        return null;
    }

    @Override
    public Img_blog selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Img_blog imgBlog) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Img_blog imgBlog) throws SQLException {

    }
}
