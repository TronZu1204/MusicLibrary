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
import java.util.Date;
import java.util.List;

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
        url= "/index.jsp";
        }
        else if(action.equals("loginUser")){
            List<User> u = loginUser(request,response);
            
            if(u == null){
                request.setAttribute("message", "Unknown user, please try again");
                url="/index.jsp";
            }
            else{
                User user = u.get(1);
                request.setAttribute("loggeduser", user);
                url="/index.jsp";
            }
        }
        else if(action.equals("logoutUser")){
            request.removeAttribute("loggedUser");
            url="/index.jsp";
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
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        User user = new User();
        user.setCreated(date);
        user.setName(name);
        user.setGmail(email);
        user.setPhoneNumber(Phone);
        user.setPass(pass);
        
        UserDB.insertUser(user);
        String url = "/" + name;
        return url;
    }

    private List<User> loginUser(HttpServletRequest request, HttpServletResponse response){
                String loginEmail = request.getParameter("loginEmail");
                String loginPass = request.getParameter("loginPass");
                List<User> u = null;
                boolean check = UserDB.userExist(loginEmail, loginPass);
                System.out.println("User excist: "+check);
                if(check == true){
                u = UserDB.selectUser(loginEmail, loginPass);
                return u;
                }
                else{
                    return null;
                }
    }
}
