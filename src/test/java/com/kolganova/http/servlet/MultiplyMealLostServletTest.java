package com.kolganova.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MultiplyMealLostServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletContext context;
    MultiplyMealLostServlet servlet;

    @BeforeEach
    void init() {
        dispatcher = mock(RequestDispatcher.class);
        servlet = new MultiplyMealLostServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        context = mock(ServletContext.class);
    }
    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getServletContext()).thenReturn(context);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }
}