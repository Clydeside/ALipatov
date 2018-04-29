package ru.job4j.servlets;

import ru.job4j.storage.TodoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private TodoStorage storage = TodoStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        storage.deleteTodo(id);
        resp.sendRedirect(String.format("%s/todo", req.getContextPath()));
    }
}
