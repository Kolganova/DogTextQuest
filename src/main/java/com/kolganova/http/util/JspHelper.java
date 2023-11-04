package com.kolganova.http.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

@UtilityClass
public class JspHelper {

    @Setter
    private static HttpServletRequest request;
    public static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String JSP_FORMAT = "WEB-INF/jsp/%s.jsp";

    @SneakyThrows
    public static String getPath(String jspName) {
        if (jspExists(jspName, request)) {
            return JSP_FORMAT.formatted(jspName);
        }

        return JSP_FORMAT.formatted("greeting");
    }

    private boolean jspExists(String jspName, HttpServletRequest request) {
        if (jspName != null) {
            try {
                if (request.getServletContext().getResource(request.getServletContext().getRealPath(JSP_FORMAT.formatted(jspName))) != null) {
                    logger.info("Полный путь к jsp-файлу с именем - " + jspName + " успешно получен");
                    return true;
                } else {
                    logger.error("Не существует jsp-файла с именем - " + jspName);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Имя jsp-файла не может быть null");
        }
        return false;
    }
}
