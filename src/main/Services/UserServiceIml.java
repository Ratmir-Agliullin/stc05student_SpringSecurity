package main.Services;

import main.DAO.UserDAO;
import main.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 20.04.2017.
 */
@Service
public class UserServiceIml implements main.Services.UserServiceInterface {
    private static UserDAO userDAO;
    @Override
    public void auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login,password);
    }

    public void  UpdateUserPass(String login, String password) {
        User user2;
        User user = userDAO.update(user2);
    }
}
