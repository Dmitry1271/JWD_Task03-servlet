package by.tc.webproject.dao;

import by.tc.webproject.dao.impl.UserDAOImpl;

/**
 * Created by cplus on 11.11.2017.
 */
public final class UserDAOFactory {
    private final static UserDAOFactory instance = new UserDAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();

    private UserDAOFactory() {
    }

    public static UserDAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
