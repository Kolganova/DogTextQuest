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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JumpingDogServletTest {

    @Mock
    HttpServletResponse response;
    @Mock
    HttpServletRequest request;
    @Mock
    RequestDispatcher dispatcher;
    JumpingDogServlet servlet;

    @BeforeEach
    void init() {
        servlet = new JumpingDogServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        String attributeName = "dogOnArmsAcceptance";

        servlet.doGet(request, response);

        verify(request).setAttribute(attributeName, List.of(Acceptance.values()));
        verify(request).getRequestDispatcher(JspHelper.getPath("jumping-dog"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    void doPostRedirect_ACCEPT_Test() throws IOException {
        when(request.getParameter("dogOnArmsAcceptance")).thenReturn("ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.LONELY_LOST);
    }
    @Test
    void doPostRedirectNot_NOT_ACCEPT_Test() throws IOException {
        when(request.getParameter("dogOnArmsAcceptance")).thenReturn("NOT_ACCEPT");

        servlet.doPost(request, response);

        verify(response).sendRedirect(UrlPath.GIVE_FOOD);
    }

}