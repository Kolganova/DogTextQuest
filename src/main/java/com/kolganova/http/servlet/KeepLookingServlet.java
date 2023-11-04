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

@WebServlet(value = KEEP_LOOKING_URL)
public class KeepLookingServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String parameterName = "keepLookingAcceptance";

    private final String servletName = "KeepLookingServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        req.setAttribute(parameterName, List.of(Acceptance.values()));
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        req.getRequestDispatcher(JspHelper.getPath(JspName.KEEP_LOOKING_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.info(LoggerHelper.createStartTextForPostLog(servletName));
        UserAnswer.setKeepLookingAcceptance(Acceptance.valueOf(req.getParameter(parameterName)));

        processKeepLookingResponse(UserAnswer.getKeepLookingAcceptance(), req, resp);
    }

    private void processKeepLookingResponse(Acceptance acceptance, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createTextForProcessMethodLog(acceptance, servletName, parameterName));

        if (acceptance == Acceptance.ACCEPT) {
            req.getRequestDispatcher(JspHelper.getPath(JspName.SINGLE_MEAL_LOST_JSP)).forward(req, resp);
        } else if (acceptance == Acceptance.NOT_ACCEPT) {
            resp.sendRedirect(MULTIPLY_MEAL_LOST_URL);
        }
    }

}
