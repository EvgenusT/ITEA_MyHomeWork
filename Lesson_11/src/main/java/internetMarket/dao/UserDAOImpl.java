package internetMarket.dao;

import internetMarket.DbConnectionUtils;
import internetMarket.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements DAO<User> {

    private User convertToModel(ResultSet resultSet) throws SQLException {
        int user_id = resultSet.getInt("user_id");
        String name = resultSet.getString("name");
        String address = resultSet.getString("address");
        String email = resultSet.getString("email");
        String gender = resultSet.getString("gender");
        LocalDate dateOfbirth = resultSet.getDate("dateOfbirth").toLocalDate();
        return new User(user_id, name, address, email, gender, dateOfbirth);
    }

    @Override
    public User findById(int id) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "Select * From users Where user_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "Select * From users;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(convertToModel(resultSet));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public void create(User model) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getUser_id());
            statement.setString(2, model.getName());
            statement.setString(3, model.getAddress());
            statement.setString(4, model.getEmail());
            statement.setString(5, model.getGender());
            statement.setDate(6, Date.valueOf(model.getDateOfBirth()));
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void update(User model) {

        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ?, " +
                    "address = ?, email = ?, gender = ?, dateOfBirth = ? WHERE user_id = ?;");
            statement.setString(1, model.getName());
            statement.setString(2, model.getAddress());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getGender());
            statement.setDate(5, Date.valueOf(model.getDateOfBirth()));
            statement.setInt(6, model.getUser_id());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void deleteById(int id) {

        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public User findByEmail(String email) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?;");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public User findByDateOfBirth(LocalDate birthDate) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE dateOfBirth = ?;");
            Date date = Date.valueOf(birthDate);
            statement.setDate(1, date);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
