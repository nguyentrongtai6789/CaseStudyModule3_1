package DAO;

import connection.MyConnection;
import model.Blog;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements I_DAO<Category>{
    private static final long serialVersionUID = 1L;

    private static final String SELECT_CATEGORY_BY_ID = "select * from CATEGORY where id =?;";
    private static final String SELECT_ALL_CATEGORY = "select * from CATEGORY;";
    private final Connection connection = MyConnection.getInstance();
    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                categoryList.add(new Category(id, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category selectOne(int id) {
        Category category = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                category = new Category(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Category category) throws SQLException {

    }
}
