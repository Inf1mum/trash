package controllers;

import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import services.*;


@WebServlet("/Cancel")
public class Cancel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

         Services service=new Services();

         ArrayList A = new ArrayList<User>();
         service.getAllUsers(A);

         req.setAttribute("A", A);

         RequestDispatcher dispatch = req.getRequestDispatcher("/Wind2Admin.jsp");
         dispatch.forward(req, resp);



    }


}
