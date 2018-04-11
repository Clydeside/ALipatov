package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServlet extends HttpServlet {
    private List<String> users = new CopyOnWriteArrayList<>();

    public List<String> getUsers() {
        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();;
        writer.append("Hello, this is a servlet!");
        StringBuilder builder = new StringBuilder("<table>");
        for (String login : this.users) {
            builder.append("<tr><td>" + login + "</td></tr>");
        }
        builder.append("</table>");
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Echo</title>" +
                "</head>" +
                "<body>" +
                "<form action = '" + req.getContextPath() + "/echo' method = 'post'>" +
                "Name : <input type='text' name='login'/>" +
                "<input type='submit'>" +
                "</form>" +
                "<br>" +
                builder.toString() +
                "</body>" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("login");
        users.add(name);
        doGet(req, resp);
    }
}
