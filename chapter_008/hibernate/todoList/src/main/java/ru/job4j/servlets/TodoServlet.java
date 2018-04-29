package ru.job4j.servlets;

import ru.job4j.models.Todo;
import ru.job4j.storage.TodoStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TodoServlet extends HttpServlet {
    private TodoStorage storage = TodoStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        TodoStorage storage = TodoStorage.getInstance();
        List<Todo> todosList = storage.getAllTodos();
        req.setAttribute("todos", todosList);
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
    }
}
