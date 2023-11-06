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

class JumpingDogServletTest extends BaseServletTest {

    @InjectMocks
    JumpingDogServlet servlet;

    @Test
    @DisplayName("doGer success forward AND sst dogOnArmsAcceptance attribute")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        String attributeName = "dogOnArmsAcceptance";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher("WEB-INF/jsp/jumping-dog.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success sendRedirect if parameter is ACCEPT")
    void doPostSendRedirect_ACCEPT_Test() throws IOException {
        when(request.getParameter("dogOnArmsAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.LONELY_LOST_URL);
    }

    @Test
    @DisplayName("doPost success sendRedirect if parameter is NOT_ACCEPT")
    void doPostSendRedirectNot_NOT_ACCEPT_Test() throws IOException {
        when(request.getParameter("dogOnArmsAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.GIVE_FOOD_URL);
    }

}