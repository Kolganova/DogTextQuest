package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
import com.kolganova.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.kolganova.http.util.UrlPath.WIN;

@WebServlet(WIN)
public class WinServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User.setWins(User.getWins() + 1);
        req.getSession().setAttribute("winsCounter", User.getWins());
        req.getRequestDispatcher(JspHelper.getPath("win")).forward(req, resp);
    }

}
