package internetMarket.dao;

import internetMarket.DbConnectionUtils;
import internetMarket.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplement implements DAO<Product> {

    @Override
    public Product findById(int id) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("Select * From products Where product_id = ? ;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private Product convertToModel(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("product_id");
        String name = resultSet.getString("name");
        String category = resultSet.getString("category");
        BigDecimal price = resultSet.getBigDecimal("price");
        return new Product(productId, name, category, price);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "Select * From products ;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                products.add(convertToModel(resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return products;
    }

    @Override
    public void create(Product model) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?);");
            statement.setInt(1, model.getProductId());
            statement.setString(2, model.getName());
            statement.setString(3, model.getCategory());
            statement.setBigDecimal(4, model.getPrice());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void update(Product model) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, category = ?, price = ? WHERE product_id = ?;");
            statement.setString(1, model.getName());
            statement.setString(2, model.getCategory());
            statement.setBigDecimal(3, model.getPrice());
            statement.setInt(4, model.getProductId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void deleteById(int id) {

        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE product_id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
