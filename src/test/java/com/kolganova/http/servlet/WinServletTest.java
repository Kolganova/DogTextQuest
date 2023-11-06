package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.mockito.Mockito.*;

class WinServletTest extends BaseServletTest {
    @InjectMocks
    WinServlet servlet;

    @Test
    @DisplayName("doGet success forward AND set winsCounter attribute")
    void doGetTest() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        String attributeName = "winsCounter";

        servlet.doGet(request, response);

        verify(request).getSession();
        verify(session).setAttribute(eq(attributeName), anyInt());
        verify(request).getRequestDispatcher("WEB-INF/jsp/win.jsp");
        verify(dispatcher).forward(request, response);
    }

}