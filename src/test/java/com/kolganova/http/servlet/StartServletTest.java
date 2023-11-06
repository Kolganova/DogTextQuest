package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import com.kolganova.http.entity.ChallengeAcceptance;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class StartServletTest extends BaseServletTest {
    @InjectMocks
    StartServlet servlet;

    @Test
    @DisplayName("doGet success forward AND set 3 attributes")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getSession()).thenReturn(session);
        String attributeName1 = "challengeAcceptance";
        String attributeName2 = "counter";
        String attributeName3 = "winsCounter";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName1, List.of(ChallengeAcceptance.values()));
        verify(request, times(2)).getSession();
        verify(session).setAttribute(eq(attributeName2), anyInt());
        verify(session).setAttribute(eq(attributeName3), anyInt());
        verify(request).getRequestDispatcher("WEB-INF/jsp/start.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success sendRedirect if parameter is ACCEPT")
    void doPostSendRedirect_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("challengeAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.JUMPING_DOG_URL);
    }
    @Test
    @DisplayName("doPost success sendRedirect if parameter is LET_DOG_DECIDE")
    void doPostSendRedirect_LET_DOG_DECIDE_test() throws ServletException, IOException {
        when(request.getParameter("challengeAcceptance")).thenReturn("LET_DOG_DECIDE");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.KEEP_LOOKING_URL);
    }
    @Test
    @DisplayName("doPost success forward if parameter is NOT_ACCEPT")
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getParameter("challengeAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher("WEB-INF/jsp/second-thoughts.jsp");
        verify(dispatcher).forward(request, response);
    }

}