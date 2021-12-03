package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/PreAdd")
public class PreAdd extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("Status","Add");
        req.setAttribute("Admin","Admin");
        req.setAttribute("User","User");

        RequestDispatcher dispatch = req.getRequestDispatcher("/Wind3EditAdd.jsp");
        dispatch.forward(req, resp);


    }
}