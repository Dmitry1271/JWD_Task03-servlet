package by.tc.webproject.service.impl;

import by.tc.webproject.dao.UserDAO;
import by.tc.webproject.dao.UserDAOFactory;
import by.tc.webproject.dao.exception.DAOException;
import by.tc.webproject.entity.User;
import by.tc.webproject.service.UserService;
import by.tc.webproject.service.exception.ServiceException;

import java.sql.SQLException;

/**
 * Created by cplus on 11.11.2017.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User find(String name, String surname) throws ServiceException {
        UserDAOFactory instance = UserDAOFactory.getInstance();
        UserDAO userDAO = instance.getUserDAO();

        User user = null;
        try {
            user = userDAO.find(name, surname);
        } catch (SQLException | DAOException e) {
            throw new ServiceException(e);
        }

        return user;
    }
}
