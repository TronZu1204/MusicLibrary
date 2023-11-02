/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LibraryClass.User;
import DBUtil.*;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/blog.html";
        String action = request.getParameter("action");
        if(action.equals("registerUser")){
        registerUser(request, response);
        url= "/index.html";
        }
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    private String registerUser(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("Email");
        String name = request.getParameter("Name");
        String number = request.getParameter("Number");
        String pass = request.getParameter("Password");
        long Phone = Long.parseLong(number);
        User user = new User();
        user.setName(name);
        user.setGmail(email);
        user.setPhoneNumber(Phone);
        user.setPass(pass);
        
        UserDB.insertUser(user);
        String url = "/" + name;
        return url;
    }


}
