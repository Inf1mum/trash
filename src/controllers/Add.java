package controllers;

import model.Password;
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

@WebServlet("/Add")
public class Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name="q",pass="q",fname="q",lname="q",post="q";
        name = req.getParameter("Email");
        pass = req.getParameter("Password");
        fname = req.getParameter("FName");
        lname = req.getParameter("LName");
        post= req.getParameter("Post");

        Services service=new Services();

        User U=new User(name,fname,lname,post);
        Password P=new Password(pass);
        service.addUser(U);
        service.addPassword(P);

        ArrayList<User> A=new ArrayList<>();

        service.getAllUsers(A);

        req.setAttribute("A", A);

        RequestDispatcher dispatch = req.getRequestDispatcher("/Wind2Admin.jsp");
        dispatch.forward(req, resp);

    }

}
