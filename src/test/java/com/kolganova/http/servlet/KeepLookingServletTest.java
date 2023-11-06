package com.kolganova.http.servlet;

import com.kolganova.http.BaseServletTest;
import com.kolganova.http.entity.Acceptance;
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

class KeepLookingServletTest extends BaseServletTest {
    @InjectMocks
    KeepLookingServlet servlet;

    @Test
    @DisplayName("doGet success forward AND set keepLookingAcceptance attribute")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        String attributeName = "keepLookingAcceptance";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher("WEB-INF/jsp/keep-looking.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success forward if parameter is ACCEPT")
    void doPostForward_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("keepLookingAcceptance")).thenReturn("ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).getParameter("keepLookingAcceptance");
        verify(request).getRequestDispatcher("WEB-INF/jsp/single-meal-lost.jsp");
        verify(dispatcher).forward(request, response);
    }
    @Test
    @DisplayName("doPost success forward if parameter is NOT_ACCEPT")
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("keepLookingAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("keepLookingAcceptance");
        verify(response).sendRedirect(UrlPath.MULTIPLY_MEAL_LOST_URL);
    }

}