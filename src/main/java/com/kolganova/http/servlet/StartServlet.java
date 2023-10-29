package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
import com.kolganova.http.entity.UserAnswer;
import com.kolganova.http.util.JspHelper;
import com.kolganova.http.entity.ChallengeAcceptance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User.setTries(User.getTries() + 1);
        req.setAttribute("challengeAcceptance", List.of(ChallengeAcceptance.values()));
        req.getSession().setAttribute("counter", User.getTries());
        req.getSession().setAttribute("winsCounter", User.getWins());

        req.getRequestDispatcher(JspHelper.getPath("start")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserAnswer.setAcceptance(ChallengeAcceptance.valueOf(req.getParameter("challengeAcceptance")));

        String redirectPath = "";
        switch (UserAnswer.getAcceptance()) {
            case ACCEPT -> redirectPath = "/jumping-dog";
            case LET_DOG_DECIDE -> redirectPath = "/keep-looking";
            case NOT_ACCEPT -> req.getRequestDispatcher(JspHelper.getPath("second-thoughts")).forward(req, resp);
        }
        resp.sendRedirect(redirectPath);

    }

}
