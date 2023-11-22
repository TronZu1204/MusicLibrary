/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBUtil.UserDB;
import LibraryClass.User;
import java.util.List;

/**
 *
 * @author GIGABYTE
 */
public class adminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       List allUser = UserDB.selectAllUser();
       request.setAttribute("allUser", allUser);
       String message = null;
       String action = request.getParameter("action");
       if(action.equals("deleteUser")){
           deleteUser(request,response);
       }
       if(action.equals("configUser")){
           if(configUser(request,response)){
               message ="Update account succecfully";
           }
           else message ="Failed to update"; 
       }
       allUser = UserDB.selectAllUser();
       request.setAttribute("allUser", allUser);
       request.setAttribute("message", message);
       String url = "/Admin.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    
private void deleteUser(HttpServletRequest request, HttpServletResponse response){
        String ID = request.getParameter("userID");
         User u = new User();
         long userID = Long.parseLong(ID);
          u.setUserID(userID);
          UserDB.deleteUser(u);
    }
private boolean configUser(HttpServletRequest request, HttpServletResponse response){
    String ID = request.getParameter("userID");
    String name = request.getParameter("userName");
    String pass = request.getParameter("userPass");
    long userID = Long.parseLong(ID); 
    User u = new User();
    u.setUserID(userID);
    u.setName(name);
    u.setPass(pass);
    boolean i = UserDB.updateUserbyAdmin(u);
    return i;
}
}
