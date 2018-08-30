package ru.job4j.servlets;

import ru.job4j.models.Car;
import ru.job4j.storage.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarsByMark extends HttpServlet {
    private CarStorage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = storage.getAllCarsByMark(req.getParameter("mark"));
        req.setAttribute("cars", cars);
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
    }
}
