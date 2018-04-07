package ru.job4j.userApplication;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SignInControllerTest {
    @Test
    public void signInControllerTest() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getParameter("login")).thenReturn("root");
        when(req.getParameter("password")).thenReturn("root");
        when(req.getSession()).thenReturn(session);

        SignInController controller = new SignInController();
        controller.doPost(req, resp);

        verify(resp, atLeastOnce()).sendRedirect(anyString());
    }
}