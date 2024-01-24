package com.example.exercice1.servlet;

import com.example.exercice1.model.User;
import com.example.exercice1.sevice.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="user", value="/user")
public class ServletUser extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authenticateUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticatedUser", username);

            response.sendRedirect("product");
        } else {
            response.sendRedirect("product");
        }
    }

    private boolean authenticateUser(String username, String password) {
        User user = userService.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/views/userList.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User(username, password);
        userService.createUser(newUser);

        response.sendRedirect("product");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User existingUser = userService.getUserById(userId);

        if (existingUser != null) {
            existingUser.setUsername(username);
            existingUser.setPassword(password);

            userService.updateUser(existingUser);
        }

        listUsers(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(userId);

        listUsers(request, response);
    }
}


