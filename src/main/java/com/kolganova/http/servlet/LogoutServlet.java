package com.kolganova.http.servlet;

import com.kolganova.http.entity.User;
import com.kolganova.http.util.JspHelper;
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
import static com.kolganova.http.util.UrlPath.LOGOUT_URL;

@WebServlet(LOGOUT_URL)
public class LogoutServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private final String servletName = "LogoutServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        req.getSession().invalidate();
        User.getInstance().setTries(0);
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        resp.sendRedirect(GREETING_URL);
    }

}
