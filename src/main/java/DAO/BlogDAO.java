package DAO;

import connection.MyConnection;
import model.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO{
    private static final long serialVersionUID = 1L;
    private static final String INSERT_BLOG_SQL = "insert into BLOG(email, password) values (?, ?);";
    private static final String SELECT_BLOG_BY_ID = "select id, email, password from account where id =?;";
    private static final String SELECT_ALL_BLOG = "select * from BLOG;";
    private static final String DELETE_BLOG_SQL = "delete from account where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update account set password = ? where id = ?;";
    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Blog> selectAll() {
        List<Blog> blogList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BLOG)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String tittle = resultSet.getString("tittle");
            String content = resultSet.getString("content");
            String create_at = resultSet.getString("create_at");
            LocalDate date = LocalDate.parse(create_at);
            int id_category = resultSet.getInt("id_category");
            int id_account = resultSet.getInt("id_account");
            blogList.add( new Blog(id, tittle, content, date, id_category, id_account));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogList;
    }

    @Override
    public Blog selectOne(int id) {
        return null;
    }

    @Override
    public void insert(Blog blog) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Blog blog) throws SQLException {

    }
}
