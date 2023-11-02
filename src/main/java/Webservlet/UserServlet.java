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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        String number = request.getParameter("number");
        String pass = request.getParameter("Password");
        int Phone = Integer.parseInt(number);
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
