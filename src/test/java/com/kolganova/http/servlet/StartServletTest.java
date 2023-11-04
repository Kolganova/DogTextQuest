package com.kolganova.http.servlet;

import com.kolganova.http.entity.ChallengeAcceptance;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class StartServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletContext context;
    StartServlet servlet;

    @BeforeEach
    void init() {
        dispatcher = mock(RequestDispatcher.class);
        servlet = new StartServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        context = mock(ServletContext.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        HttpSession session = mock(HttpSession.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getSession()).thenReturn(session);
        when(request.getServletContext()).thenReturn(context);
        String attributeName1 = "challengeAcceptance";
        String attributeName2 = "counter";
        String attributeName3 = "winsCounter";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName1, List.of(ChallengeAcceptance.values()));
        verify(request, times(2)).getSession();
        verify(session).setAttribute(eq(attributeName2), anyInt());
        verify(session).setAttribute(eq(attributeName3), anyInt());
        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPostSendRedirect_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("challengeAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.JUMPING_DOG);
    }
    @Test
    void doPostSendRedirect_LET_DOG_DECIDE_test() throws ServletException, IOException {
        when(request.getParameter("challengeAcceptance")).thenReturn("LET_DOG_DECIDE");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.KEEP_LOOKING);
    }
    @Test
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getParameter("challengeAcceptance")).thenReturn("NOT_ACCEPT");
        when(request.getServletContext()).thenReturn(context);

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher(anyString());
        verify(dispatcher).forward(request, response);
    }

}