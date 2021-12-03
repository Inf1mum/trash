package controllers;

import model.Password;
import model.User;
import services.Services;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



@WebServlet("/LogIn")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("Email");
        String pass = req.getParameter("Password");



        Services service=new Services();

        ArrayList<User> A = new ArrayList<>();
        ArrayList<Password> B=new ArrayList<>();

        service.getAllUsers(A);
        service.getAllPasswords(B);
        req.setAttribute("A", A);

            int k = 0;
            req.setAttribute("A", A);


           for (int i=0;i<A.size();i++) {
                String email = A.get(i).getEmail();

                if (email.equals(name) && B.get(i).checkPassword(pass)) {
                    RequestDispatcher dispatch = req.getRequestDispatcher("/Wind2" + A.get(i).getPost() + ".jsp");
                    dispatch.forward(req, resp);
                    k++;

                }
           }
            if (k == 0) {
                RequestDispatcher dispatch = req.getRequestDispatcher("/ErrorLogin.jsp");
                dispatch.forward(req, resp);
            }

    }

}