package com.kolganova.http.servlet;

import com.kolganova.http.util.JspHelper;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.MULTIPLY_MEAL_LOST)
public class MultiplyMealLostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("multiply-meal-lost")).forward(req, resp);
    }
}
