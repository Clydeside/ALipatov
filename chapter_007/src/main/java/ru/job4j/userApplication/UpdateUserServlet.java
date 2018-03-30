package ru.job4j.userApplication;

import ru.job4j.models.User;
import ru.job4j.resourses.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserServlet extends HttpServlet {
    private UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Please, fill the form:");
        out.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Update</title>" +
                "</head>" +
                "<body>" +
                "<form action = '" + req.getContextPath() + "/update' method = 'post'>" +
                "User ID : <input type='text' name='id'/>" +
                "Name : <input type='text' name='name'/>" +
                "Login : <input type='text' name='login'/>" +
                "<input type='submit'>" +
                "</form>" +
                "<br>" +
                "</body>" +
                "</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        User user = new User(name, login);
        user.setId(id);
        storage.updateUser(user);
        resp.sendRedirect("list");
    }
}
