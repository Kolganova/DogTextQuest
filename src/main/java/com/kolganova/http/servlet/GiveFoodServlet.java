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

import static com.kolganova.http.util.UrlPath.GIVE_FOOD_URL;
import static com.kolganova.http.util.UrlPath.PET_DOG_URL;

@WebServlet(GIVE_FOOD_URL)
public class GiveFoodServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String parameterName = "giveFoodAcceptance";
    private final String servletName = "GiveFoodServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForGetLog(servletName));
        req.setAttribute(parameterName, List.of(Acceptance.values()));
        logger.info(LoggerHelper.createEndTextForGetLog(servletName));
        req.getRequestDispatcher(JspHelper.getPath(JspName.GIVE_FOOD_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createStartTextForPostLog(servletName));
        UserAnswer.setGiveFoodAcceptance(Acceptance.valueOf(req.getParameter(parameterName)));

        processGiveFoodAcceptanceResponse(UserAnswer.getGiveFoodAcceptance(), req, resp);

    }

    private void processGiveFoodAcceptanceResponse(Acceptance acceptance, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(LoggerHelper.createTextForProcessMethodLog(acceptance, servletName, parameterName));

        if (acceptance == Acceptance.ACCEPT) {
            req.getRequestDispatcher(JspHelper.getPath(JspName.LET_DOG_EAT_JSP)).forward(req, resp);
        } else if (acceptance == Acceptance.NOT_ACCEPT) {
            resp.sendRedirect(PET_DOG_URL);
        }
    }

}
