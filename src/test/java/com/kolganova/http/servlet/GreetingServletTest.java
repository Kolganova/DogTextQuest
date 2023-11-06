package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GreetingServletTest extends BaseServletTest {
    @InjectMocks
    private GreetingServlet servlet;

    @Test
    @DisplayName("doGet success forward")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher("WEB-INF/jsp/greeting.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success sendRedirect AND set name attribute")
    void doPostSendRedirectTest() throws IOException {
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        String attributeName = "name";

        servlet.doPost(request, response);

        verify(request).getSession();
        verify(session).setAttribute(eq(attributeName), isNull());
        verify(response).sendRedirect(UrlPath.START_URL);
    }

}