package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.kolganova.http.util.UrlPath.GREETING;
import static com.kolganova.http.util.UrlPath.LOGOUT;

@WebServlet(LOGOUT)
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        User.setTries(0);
        resp.sendRedirect(GREETING);
    }

}
