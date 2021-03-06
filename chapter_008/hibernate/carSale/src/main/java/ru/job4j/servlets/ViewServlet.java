package ru.job4j.servlets;

import ru.job4j.models.Car;
import ru.job4j.storage.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewServlet extends HttpServlet {
    private CarStorage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("html/text");
        List<Car> cars = storage.getAllCars();
        req.setAttribute("cars", cars);
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
    }
}
