package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class LonelyLostServletTest extends BaseServletTest {
    @InjectMocks
    LonelyLostServlet servlet;

    @Test
    @DisplayName("doGet success forward")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher("WEB-INF/jsp/lonely-lost.jsp");
        verify(dispatcher).forward(request, response);
    }

}