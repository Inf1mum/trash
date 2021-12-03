package controllers;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import services.*;


@WebServlet("/PreEdit")
public class PreEdit extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long Id = Long.parseLong(req.getParameter("id"));
        int id=(int)Id;
        User B=new User();

        Services service=new Services();

        service.getUser(B,id);

        req.setAttribute("Email",B.getEmail());
        req.setAttribute("Pass","");
        req.setAttribute("LName",B.getLName());
        req.setAttribute("FName", B.getFName());
        req.setAttribute("id",id);
        req.setAttribute("Status","Edit");

        if(B.getPost().charAt(0)=='A'){
              req.setAttribute("Admin","Admin");
              req.setAttribute("User","User");
            }
        else
            {
             req.setAttribute("Admin","User");
             req.setAttribute("User","Admin");
            }


        RequestDispatcher dispatch = req.getRequestDispatcher("/Wind3EditAdd.jsp");
        dispatch.forward(req, resp);

    }




}
