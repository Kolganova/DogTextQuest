package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
import com.kolganova.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.kolganova.http.util.UrlPath.GREETING;
import static com.kolganova.http.util.UrlPath.START;

@WebServlet(GREETING)
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User.setTries(0);
        User.setWins(0);
        req.getRequestDispatcher(JspHelper.getPath("greeting")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User.setName(req.getParameter("name"));
        req.getSession().setAttribute("name", User.getName());
        resp.sendRedirect(START);
    }

}
