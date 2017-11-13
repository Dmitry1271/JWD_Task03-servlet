package by.tc.webproject.service;

import by.tc.webproject.service.impl.UserServiceImpl;

/**
 * Created by cplus on 11.11.2017.
 */
public final class UserServiceFactory {
    private static final UserServiceFactory instance = new UserServiceFactory();
    private final UserService userService = new UserServiceImpl();

    private UserServiceFactory() {
    }

    public static UserServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
}
