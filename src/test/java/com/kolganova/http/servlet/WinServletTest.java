package com.kolganova.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.Mockito.*;

class WinServletTest {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletContext context;
    WinServlet servlet;

    @BeforeEach
    void init() {
        dispatcher = mock(RequestDispatcher.class);
        servlet = new WinServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        context = mock(ServletContext.class);
    }
    @Test
    void doGetTest() throws ServletException, IOException {
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getServletContext()).thenReturn(context);
        String attributeName = "winsCounter";

        servlet.doGet(request, response);

        verify(request).getSession();
        verify(session).setAttribute(eq(attributeName), anyInt());
        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }
}