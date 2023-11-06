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

class PetDogServletTest extends BaseServletTest {
    @InjectMocks
    PetDogServlet servlet;

    @Test
    @DisplayName("doGet success forward AND set petDogAcceptance attribute")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        String attributeName = "petDogAcceptance";

        servlet.doGet(request, response);
        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher("WEB-INF/jsp/pet-dog.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success sendRedirect if parameter is ACCEPT")
    void doPostSendRedirect_ACCEPT_test() throws IOException, ServletException {
        when(request.getParameter("petDogAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("petDogAcceptance");
        verify(response).sendRedirect(UrlPath.WIN_URL);
    }

    @Test
    @DisplayName("doPost success forward if parameter is NOT_ACCEPT")
    void doPostForward_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("petDogAcceptance")).thenReturn("NOT_ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).getParameter("petDogAcceptance");
        verify(request).getRequestDispatcher("WEB-INF/jsp/dont-pet-dog-lost.jsp");
        verify(dispatcher).forward(request, response);
    }

}