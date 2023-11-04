package com.kolganova.http.servlet;

import com.kolganova.http.entity.Acceptance;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class KeepLookingServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher requestDispatcher;
    @Mock
    ServletContext context;
    KeepLookingServlet servlet;

    @BeforeEach
    void init() {
        servlet = new KeepLookingServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
        context = mock(ServletContext.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        when(request.getServletContext()).thenReturn(context);
        String attributeName = "keepLookingAcceptance";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher(anyString());
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doPostForward_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("keepLookingAcceptance")).thenReturn("ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        when(request.getServletContext()).thenReturn(context);

        servlet.doPost(request, response);

        verify(request).getParameter("keepLookingAcceptance");
        verify(request).getRequestDispatcher(anyString());
        verify(requestDispatcher).forward(request, response);
    }
    @Test
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("keepLookingAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("keepLookingAcceptance");
        verify(response).sendRedirect(UrlPath.MULTIPLY_MEAL_LOST_URL);
    }

}