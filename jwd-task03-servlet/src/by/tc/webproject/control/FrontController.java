package by.tc.webproject.control;

import by.tc.webproject.dao.exception.DAOException;
import by.tc.webproject.entity.User;
import by.tc.webproject.service.UserService;
import by.tc.webproject.service.UserServiceFactory;
import by.tc.webproject.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by cplus on 12.11.2017.
 */
public class FrontController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceFactory instance = UserServiceFactory.getInstance();
        UserService userService = instance.getUserService();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        try {
            User user = userService.find(request.getParameter("name"), request.getParameter("surname"));

            request.setAttribute("userBean", user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userInfo.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | DAOException | ServiceException e) {
            e.printStackTrace();
        }
    }
}
