package com.kolganova.http.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class JspHelper {

    public static final Logger logger = LoggerFactory.getLogger(JspHelper.class);
    private static final String JSP_FORMAT = "WEB-INF/jsp/%s.jsp";

    @SneakyThrows
    public static String getPath(String jspName) {
        if (jspIsNotNull(jspName)) {
            return JSP_FORMAT.formatted(jspName);
        }

        return JSP_FORMAT.formatted("greeting");
    }
    private boolean jspIsNotNull(String jspName) {
        if (jspName != null) {
            logger.info("Попытка получения полного пути к jsp-файлу с именем - " + jspName);
            return true;
        } else {
            logger.error("Имя jsp-файла не может быть null");
            return false;
        }
    }
}
