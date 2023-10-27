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

@WebServlet("/jumping-dog")
public class JumpingDogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogOnArmsAcceptance", List.of(Acceptance.values()));
        req.getRequestDispatcher(JspHelper.getPath("jumping-dog")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserAnswer.setDogOnArmsAcceptance(Acceptance.valueOf(req.getParameter("dogOnArmsAcceptance")));

        String redirectPath = "";
        switch (UserAnswer.getDogOnArmsAcceptance()) {
            case ACCEPT -> redirectPath = "/lonely-lost";
            case NOT_ACCEPT -> redirectPath = "/give-food";
        }
        resp.sendRedirect(redirectPath);
    }

}
