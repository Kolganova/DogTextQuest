package com.kolganova.http.servlet;

import com.kolganova.http.entity.Acceptance;
import com.kolganova.http.util.JspHelper;
import com.kolganova.http.util.UrlPath;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class GiveFoodServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher requestDispatcher;
    GiveFoodServlet servlet;

    @BeforeEach
    void init() {
        servlet = new GiveFoodServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        String attributeName = "giveFoodAcceptance";

        servlet.doGet(request, response);
        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher(JspHelper.getPath("give-food"));
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doPostSendRedirect_NOT_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("giveFoodAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(request).getParameter("giveFoodAcceptance");
        verify(response).sendRedirect(UrlPath.PET_DOG);
    }

    @Test
    void doPostForward_ACCEPT_test() throws ServletException, IOException {
        when(request.getParameter("giveFoodAcceptance")).thenReturn("ACCEPT");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).getParameter("giveFoodAcceptance");
        verify(request).getRequestDispatcher(JspHelper.getPath("let-dog-eat"));
        verify(requestDispatcher).forward(request, response);
    }

}
