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

@WebServlet("/pet-dog")
public class PetDogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("petDogAcceptance", List.of(Acceptance.values()));
        req.getRequestDispatcher(JspHelper.getPath("pet-dog")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAnswer.setPetDogAcceptance(Acceptance.valueOf(req.getParameter("petDogAcceptance")));

        String forwardPath = "";
        switch (UserAnswer.getPetDogAcceptance()) {
            case ACCEPT -> forwardPath = "win";
            case NOT_ACCEPT -> forwardPath = "dont-pet-dog-lost";
        }
        req.getRequestDispatcher(JspHelper.getPath(forwardPath)).forward(req, resp);
    }

}
