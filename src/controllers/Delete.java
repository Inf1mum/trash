package controllers;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

import services.*;

@WebServlet("/Del")
public class Delete extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            long Id = Long.parseLong(req.getParameter("id"));
            int id=(int)Id;

            Services service=new Services();

            service.deleteUser(id);
            service.deletePassword(id);

            ArrayList<User> A=new ArrayList<>();
            service.getAllUsers(A);

            req.setAttribute("A", A);

            RequestDispatcher dispatch = req.getRequestDispatcher("/Wind2Admin.jsp");
            dispatch.forward(req, resp);
        }




}
