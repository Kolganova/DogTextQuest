package com.kolganova.http.servlet;

import com.kolganova.http.entity.Acceptance;
import com.kolganova.http.entity.UserAnswer;
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

import static com.kolganova.http.util.UrlPath.*;

@WebServlet(JUMPING_DOG_URL)
public class JumpingDogServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String parameterName = "dogOnArmsAcceptance";
    private final String servletName = "JumpingDogServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        req.setAttribute(parameterName, List.of(Acceptance.values()));
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        req.getRequestDispatcher(JspHelper.getPath(JspName.JUMPING_DOG_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info(LoggerHelper.createStartTextForPostLog(servletName));
        UserAnswer.setDogOnArmsAcceptance(Acceptance.valueOf(req.getParameter(parameterName)));

        processOnArmsResponse(UserAnswer.getDogOnArmsAcceptance(), resp);
    }

    private void processOnArmsResponse(Acceptance acceptance, HttpServletResponse resp) throws IOException {
        String redirectPath = "";
        logger.info(LoggerHelper.createTextForProcessMethodLog(acceptance, servletName, parameterName));

        if (acceptance == Acceptance.ACCEPT)
            redirectPath = LONELY_LOST_URL;
        else
            redirectPath = GIVE_FOOD_URL;

        resp.sendRedirect(redirectPath);
    }

}
