package internetMarket.dao;

import internetMarket.DbConnectionUtils;
import internetMarket.model.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO<Order> {

    private Order convertToModel(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        int productId = resultSet.getInt("product_id");
        int count = resultSet.getInt("count");
        String status = resultSet.getString("status");
        LocalDate date = resultSet.getDate("date").toLocalDate();
        return new Order(userId, productId, count, status, date);
    }


    @Override
    public List findByUserId(int userId) {
        List<Order> ordersList = new ArrayList<>();
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM orders WHERE user_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ordersList.add(convertToModel(resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return ordersList;
    }

    @Override
    public List findByUserIdAndStatus(int userId, String status) {
        List<Order> ordersList = new ArrayList<>();
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM orders WHERE user_id = ? AND status = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ordersList.add(convertToModel(resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return ordersList;
    }

    @Override
    public void createOrder(Order model) {

        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUserId());
            statement.setInt(2, model.getProductId());
            statement.setInt(3, model.getCount());
            statement.setString(4, model.getStatus());
            statement.setDate(5, Date.valueOf(model.getDate()));

            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

    }

    @Override
    public void updateOrder(Order model) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "UPDATE orders SET count = ?, status = ?, date = ? WHERE user_id = ? AND product_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, model.getCount());
            statement.setString(2, model.getStatus());
            statement.setDate(3, Date.valueOf(model.getDate()));
            statement.setInt(4, model.getUserId());
            statement.setInt(5, model.getProductId());

            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
