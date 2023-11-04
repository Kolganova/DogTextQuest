package com.kolganova.http.servlet;

import com.kolganova.http.util.UrlPath;
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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GreetingServletTest {

    @Mock
    HttpServletResponse response;
    @Mock
    HttpServletRequest request;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletContext context;
    GreetingServlet servlet;

    @BeforeEach
    void init() {
        servlet = new GreetingServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
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

    @Test
    void doPostSendRedirectTest() throws IOException {
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        String attributeName = "name";

        servlet.doPost(request, response);

        verify(request).getSession();
        verify(session).setAttribute(eq(attributeName), isNull());
        verify(response).sendRedirect(UrlPath.START);
    }

}