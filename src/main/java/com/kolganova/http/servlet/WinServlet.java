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

import static com.kolganova.http.util.UrlPath.WIN_URL;

@WebServlet(WIN_URL)
public class WinServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String parameterName = "winsCounter";
    private final String servletName = "WinServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        User.getInstance().setWins(User.getInstance().getWins() + 1);
        req.getSession().setAttribute(parameterName, User.getInstance().getWins());
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        req.getRequestDispatcher(JspHelper.getPath(JspName.WIN_JSP)).forward(req, resp);
    }

}
