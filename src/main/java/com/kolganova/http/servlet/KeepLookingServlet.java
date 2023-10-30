package com.kolganova.http.servlet;

import com.kolganova.http.entity.Acceptance;
import com.kolganova.http.entity.UserAnswer;
import com.kolganova.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.kolganova.http.util.UrlPath.KEEP_LOOKING;
import static com.kolganova.http.util.UrlPath.MULTIPLY_MEAL_LOST;

@WebServlet(value = KEEP_LOOKING)
public class KeepLookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("keepLookingAcceptance", List.of(Acceptance.values()));
        req.getRequestDispatcher(JspHelper.getPath("keep-looking")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserAnswer.setKeepLookingAcceptance(Acceptance.valueOf(req.getParameter("keepLookingAcceptance")));

        switch (UserAnswer.getKeepLookingAcceptance()) {
            case ACCEPT -> req.getRequestDispatcher(JspHelper.getPath("single-meal-lost")).forward(req, resp);
            case NOT_ACCEPT -> resp.sendRedirect(MULTIPLY_MEAL_LOST);
        }
    }

}
