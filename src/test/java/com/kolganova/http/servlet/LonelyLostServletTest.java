package com.kolganova.http.servlet;

import com.kolganova.http.util.JspHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class LonelyLostServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    LonelyLostServlet servlet;

    @BeforeEach
    void init() {
        dispatcher = mock(RequestDispatcher.class);
        servlet = new LonelyLostServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher(JspHelper.getPath("lonely-lost"));
        verify(dispatcher).forward(request, response);
    }

}