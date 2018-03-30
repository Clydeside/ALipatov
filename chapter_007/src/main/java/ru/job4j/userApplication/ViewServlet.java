package ru.job4j.userApplication;

import ru.job4j.models.User;
import ru.job4j.resourses.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ViewServlet extends HttpServlet {
    private UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        List<User> list = storage.getAllUsers();
        out.append(
                "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>UserList</title>" +
                "</head>" +
                "<body>" +
                "<h1>Users List</h1>" +
                "<a href='create'>Add New User</a><br><br>" +
                "<table border='1' width='100%'>" +
                "<tr>" +
                "<th>Id</th><th>Name</th><th>Login</th>" +
                "<th>Update</th>" +
                "<th>Delete</th>" +
                "</tr>");

        for (User user : list){
            out.print("<tr><td>" + user.getId() + "</td>");
            out.print("<td>" + user.getName() + "</td>");
            out.print("<td>" + user.getLogin() + "</td>");
            out.print("<td><a href='update'>Update</a></td>");
            out.print("<td><a href='delete'>Delete</a></td></tr>");
        }
        out.print("</table>");

        out.flush();
        out.close();
    }
}
