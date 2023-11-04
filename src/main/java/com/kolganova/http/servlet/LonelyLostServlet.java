package com.kolganova.http.servlet;

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

import static com.kolganova.http.util.UrlPath.LONELY_LOST_URL;

@WebServlet(LONELY_LOST_URL)
public class LonelyLostServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private final String servletName = "LonelyLostServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        logger.info(LoggerHelper.createEndTextForGetLog(servletName)); // ???
        req.getRequestDispatcher(JspHelper.getPath(JspName.LONELY_LOST_JSP)).forward(req, resp);
    }
}
