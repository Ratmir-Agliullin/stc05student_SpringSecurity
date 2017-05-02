package main.DAO;

import main.models.User;

import java.util.Collection;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserDAOInterface {
    Collection<User> getAll();

    User getById(Long id);

    Long insert(User entity);

    void update(User entity);

    void delete(User entity);

    User findUserByLoginAndPassword(String login, String password);
}
