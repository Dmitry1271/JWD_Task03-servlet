package by.tc.webproject.dao;

import by.tc.webproject.dao.exception.DAOException;
import by.tc.webproject.entity.User;

import java.sql.SQLException;

/**
 * Created by cplus on 11.11.2017.
 */
public interface UserDAO {
    User find(String name, String surname) throws SQLException, DAOException;
}
