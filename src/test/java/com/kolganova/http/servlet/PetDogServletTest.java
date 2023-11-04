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

class PetDogServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletContext context;
    PetDogServlet servlet;

    @BeforeEach
    void init() {
        dispatcher = mock(RequestDispatcher.class);
        servlet = new PetDogServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        context = mock(ServletContext.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getServletContext()).thenReturn(context);
        String attributeName = "petDogAcceptance";

        servlet.doGet(request, response);
        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPostSendRedirect_ACCEPT_test() throws IOException, ServletException {
        when(request.getParameter("petDogAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("petDogAcceptance");
        verify(response).sendRedirect(UrlPath.WIN);
    }

    @Test
    void doPostForward_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("petDogAcceptance")).thenReturn("NOT_ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getServletContext()).thenReturn(context);

        servlet.doPost(request, response);

        verify(request).getParameter("petDogAcceptance");
        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }
}