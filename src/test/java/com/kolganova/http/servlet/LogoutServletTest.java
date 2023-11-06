package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LogoutServletTest extends BaseServletTest {
    @InjectMocks
    LogoutServlet servlet;

    @Test
    @DisplayName("doGet success sendRedirect AND session invalidation")
    void doGetTest() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);

        servlet.doGet(request, response);

        verify(request).getSession();
        verify(session).invalidate();
        verify(response).sendRedirect(UrlPath.GREETING_URL);
    }

}