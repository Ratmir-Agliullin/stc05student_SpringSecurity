package main.DAO;

import main.models.ConnectionPool;
import main.models.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by admin on 20.04.2017.
 */
public class UserDAO implements UserDAOInterface {
    private static Logger log = Logger.getLogger(UserDAO.class.getName());

    @Override
    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public User getById(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public Long insert(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void update(User entity, String newLogin, String newPass) {
        throw new NotImplementedException();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set password = ? where id=?");
            preparedStatement.setString(1, entity.setPassword());
            preparedStatement.setInt(2, entity.setId());

// подумать над входными параметрами

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info(e.toString());
        }
    }

    @Override
    public void delete(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "SELECT * FROM user_st WHERE login = ? AND password = ?")) {

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

           // log.debug("user " + user);
        } catch (SQLException e) {
           // log.error(e);
        }

        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getBoolean("is_blocked"));
    }
}
