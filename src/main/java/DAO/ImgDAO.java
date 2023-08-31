package DAO;

import connection.MyConnection;
import model.Blog;
import model.Img_blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImgDAO implements I_DAO<Img_blog>{
    private static final long serialVersionUID = 1L;
    private static final String INSERT_IMG_SQL = "insert into IMG_BLOG(url_image, id_blog)" +
            "values (?, ?);";
    private static final String SELECT_IMG_BY_ID = "select * from blog where id =?;";
    private static final String SELECT_ALL_IMG = "select * from BLOG;";
    private static final String DELETE_BLOG_SQL = "delete from account where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update account set password = ? where id = ?;";
    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Img_blog> selectAll() {
//        List<Img_blog> Img_blog = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BLOG)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String tittle = resultSet.getString("tittle");
//                String content = resultSet.getString("content");
//                String create_at = resultSet.getString("create_at");
//                LocalDate date = LocalDate.parse(create_at);
//                int id_category = resultSet.getInt("id_category");
//                int id_account = resultSet.getInt("id_account");
//                blogList.add(new Blog(id, tittle, content, date, id_category, id_account));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return blogList;
        return null;
    }

    @Override
    public Img_blog selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Img_blog imgBlog) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_IMG_SQL)) {
            statement.setString(1, imgBlog.getUrl_image());
            statement.setInt(2, imgBlog.getId_blog());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Img_blog imgBlog) throws SQLException {

    }
}
