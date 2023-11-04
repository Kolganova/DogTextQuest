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

import static com.kolganova.http.util.UrlPath.MULTIPLY_MEAL_LOST_URL;

@WebServlet(MULTIPLY_MEAL_LOST_URL)
public class MultiplyMealLostServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private final String servletName = "MultiplyMealLostServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        logger.info(LoggerHelper.createEndTextForGetLog(servletName)); // ???
        req.getRequestDispatcher(JspHelper.getPath(JspName.MULTIPLY_MEAL_LOST_JSP)).forward(req, resp);
    }
}
