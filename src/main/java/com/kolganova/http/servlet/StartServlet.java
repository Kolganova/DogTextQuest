package com.kolganova.http.servlet;

import com.kolganova.http.entity.*;
import com.kolganova.http.util.JspHelper;
import com.kolganova.http.util.JspName;
import com.kolganova.http.util.LoggerHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.kolganova.http.entity.ChallengeAcceptance.*;
import static com.kolganova.http.entity.ChallengeAcceptance.LET_DOG_DECIDE;
import static com.kolganova.http.util.UrlPath.*;

@WebServlet(START_URL)
public class StartServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String parameterChallengeAcceptanceName = "challengeAcceptance";
    private static final String parameterCounterName = "counter";
    private static final String parameterWinsCounterName = "winsCounter";
    private final String servletName = "StartServlet";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        User.getInstance().setTries(User.getInstance().getTries() + 1);
        req.setAttribute(parameterChallengeAcceptanceName, List.of(values()));
        req.getSession().setAttribute(parameterCounterName, User.getInstance().getTries());
        req.getSession().setAttribute(parameterWinsCounterName, User.getInstance().getWins());
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));

        req.getRequestDispatcher(JspHelper.getPath(JspName.START_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.info(LoggerHelper.createStartTextForPostLog(servletName));
        UserAnswer.setAcceptance(valueOf(req.getParameter(parameterChallengeAcceptanceName)));

        processChallengeAcceptanceResponse(UserAnswer.getAcceptance(), req, resp);
    }

    private void processChallengeAcceptanceResponse(ChallengeAcceptance acceptance, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectPath = "";
        logger.info(LoggerHelper.createTextForProcessMethodLog(acceptance, servletName, parameterChallengeAcceptanceName));

        if (acceptance == NOT_ACCEPT) {
            req.getRequestDispatcher(JspHelper.getPath(JspName.SECOND_THOUGHTS_JSP)).forward(req, resp);
        } else if (acceptance == ACCEPT) {
            redirectPath = JUMPING_DOG_URL;
        } else if (acceptance == LET_DOG_DECIDE)
            redirectPath = KEEP_LOOKING_URL;

        resp.sendRedirect(redirectPath);
    }

}
