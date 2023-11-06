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

import static org.mockito.Mockito.*;

public class GiveFoodServletTest extends BaseServletTest {

    @InjectMocks
    private GiveFoodServlet servlet;

    @Test
    @DisplayName("doGet success forward AND set giveFoodAcceptance attribute")
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        String attributeName = "giveFoodAcceptance";

        servlet.doGet(request, response);
        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher("WEB-INF/jsp/give-food.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("doPost success sendRedirect if parameter is NOT_ACCEPT")
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("giveFoodAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("giveFoodAcceptance");
        verify(response).sendRedirect(UrlPath.PET_DOG_URL);
    }

    @Test
    @DisplayName("doPost success forward if parameter is ACCEPT")
    void doPostForward_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("giveFoodAcceptance")).thenReturn("ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).getParameter("giveFoodAcceptance");
        verify(request).getRequestDispatcher("WEB-INF/jsp/let-dog-eat.jsp");
        verify(dispatcher).forward(request, response);
    }

}
