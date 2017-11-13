package by.tc.webproject.service;

import by.tc.webproject.dao.exception.DAOException;
import by.tc.webproject.entity.User;
import by.tc.webproject.service.exception.ServiceException;

import java.sql.SQLException;

/**
 * Created by cplus on 11.11.2017.
 */
public interface UserService {
    User find(String name, String surname) throws SQLException, DAOException, ServiceException;
}
