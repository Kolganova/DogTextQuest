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

import static com.kolganova.http.util.UrlPath.GIVE_FOOD;
import static com.kolganova.http.util.UrlPath.PET_DOG;

@WebServlet(GIVE_FOOD)
public class GiveFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JspHelper.setRequest(req);
        req.setAttribute("giveFoodAcceptance", List.of(Acceptance.values()));
        req.getRequestDispatcher(JspHelper.getPath("give-food")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JspHelper.setRequest(req);
        UserAnswer.setGiveFoodAcceptance(Acceptance.valueOf(req.getParameter("giveFoodAcceptance")));

        switch (UserAnswer.getGiveFoodAcceptance()) {
            case ACCEPT -> req.getRequestDispatcher(JspHelper.getPath("let-dog-eat")).forward(req, resp);
            case NOT_ACCEPT -> resp.sendRedirect(PET_DOG);
        }
    }
}
