package com.kolganova.http.util;

import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JspHelperTest {

    public static final String startJspName = "start";
    public static final String nullJspName = null;
    public static final String greetingJspPath = "WEB-INF/jsp/greeting.jsp";
    public static final String startJspPath = "WEB-INF/jsp/start.jsp";

    @Mock
    ServletContext context;

    @BeforeEach
    void init() {
        context = mock(ServletContext.class);
    }

    @Test
    void getPath_returnsGreetingPathIfJspNameIsNull() {
        assertEquals(greetingJspPath, JspHelper.getPath(nullJspName));
    }

    @Test
    void getPath_returnsPathIfJspNameIsNotNull() {
        assertEquals(startJspPath, JspHelper.getPath(startJspName));
    }

}