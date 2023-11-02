package com.kolganova.http.servlet;

import com.kolganova.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LogoutServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    LogoutServlet servlet;

    @BeforeEach
    void init() {
        servlet = new LogoutServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    void doGetTest() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        servlet.doGet(request, response);

        verify(request).getSession();
        verify(session).invalidate();
        verify(response).sendRedirect(UrlPath.GREETING);
    }

}