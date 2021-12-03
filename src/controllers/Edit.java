package controllers;

import model.Password;
import model.User;
import services.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;


@WebServlet("/Edit")
public class Edit extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("Email");
        String pass = req.getParameter("Password");
        String lname = req.getParameter("LName");
        String fname = req.getParameter("FName");
        String post = req.getParameter("Post");
        String Id=req.getParameter("id");
        int id=Integer.parseInt(Id);

        Services service=new Services();

        User U=new User(email,fname,lname,post);
        Password P=new Password(pass);
        service.updateUser(U,id);
        service.updatePassword(P,id);

        ArrayList<User> A=new ArrayList<>();
        service.getAllUsers(A);
        req.setAttribute("A", A);

        RequestDispatcher dispatch = req.getRequestDispatcher("/Wind2Admin.jsp");
        dispatch.forward(req, resp);


    }

 }



