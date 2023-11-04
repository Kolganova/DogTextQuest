package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
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

import static com.kolganova.http.util.UrlPath.GREETING_URL;
import static com.kolganova.http.util.UrlPath.START_URL;

@WebServlet(GREETING_URL)
public class GreetingServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private final String servletName = "GreetingServlet";
    private static final String parameterName = "name";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        User.getInstance().setTries(0);
        User.getInstance().setWins(0);
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        req.getRequestDispatcher(JspHelper.getPath(JspName.GREETING_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info(LoggerHelper.createStartTextForPostLog(servletName));
        User.getInstance().setName(req.getParameter(parameterName));
        req.getSession().setAttribute(parameterName, User.getInstance().getName());
        logger.info(LoggerHelper.createEndTextForPostLog(servletName));
        resp.sendRedirect(START_URL);
    }

}
