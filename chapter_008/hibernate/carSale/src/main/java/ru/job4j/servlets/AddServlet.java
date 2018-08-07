package ru.job4j.servlets;

import ru.job4j.models.Car;
import ru.job4j.models.Engine;
import ru.job4j.models.Gearbox;
import ru.job4j.models.Transmission;
import ru.job4j.storage.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private final CarStorage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String engine = req.getParameter("engine");
        String gearbox = req.getParameter("gearbox");
        String transmission = req.getParameter("transmission");
        Car car = new Car(name);
        car.setEngine(new Engine(Integer.valueOf(engine)));
        car.setGearbox(new Gearbox(Integer.valueOf(gearbox)));
        car.setTransmission(new Transmission(Integer.valueOf(transmission)));
        storage.insertCar(car);
        resp.sendRedirect(String.format("%s/cars", req.getContextPath()));
    }
}
