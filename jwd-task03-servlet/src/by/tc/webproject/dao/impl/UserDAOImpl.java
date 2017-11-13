package by.tc.webproject.dao.impl;

import by.tc.webproject.dao.UserDAO;
import by.tc.webproject.dao.connect.ConnectorDB;
import by.tc.webproject.dao.exception.DAOException;
import by.tc.webproject.entity.User;

import java.io.IOException;
import java.sql.*;

/**
 * Created by cplus on 11.11.2017.
 */
public class UserDAOImpl implements UserDAO {
    public final static String SQL_SELECT_USER_BY_NAME_AND_SURNAME =
            "SELECT * FROM user WHERE name=? AND surname=?";

    @Override
    public User find(String name, String surname) throws DAOException, SQLException {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectorDB.getConnection();

            statement = connection.prepareStatement(SQL_SELECT_USER_BY_NAME_AND_SURNAME);
            statement.setString(1, name);
            statement.setString(2, surname);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getLong("iduser"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
            } else {
                return null;
            }

        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new DAOException(e);
        }
        return user;
    }
}
