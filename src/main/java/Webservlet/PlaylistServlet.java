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
import java.text.SimpleDateFormat;  
import java.util.Date;  

import LibraryClass.Playlist;
import DBUtil.PlaylistDB;
import LibraryClass.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author GIGABYTE
 */
public class PlaylistServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("loggeduser");
       long ID = user.getUserID();
       List<Playlist> playlist = PlaylistDB.selectPlaylist(user);
        String url ="/Playlist.jsp";
       request.setAttribute("playlist", playlist);
       String action = request.getParameter("action");
        System.out.println(action);
       if(action.equals("addPlaylist")){
           createPlaylist(request,response,ID);
           String message ="Playlist added";
           request.setAttribute("message", message);
           playlist = PlaylistDB.selectPlaylist(user);
           request.setAttribute("playlist", playlist);
           url ="/Playlist.jsp";
       }
       if(action.equals("Delete playlist")){
           deletePlaylist(request,response);
           String message ="Playlist deleted";
           request.setAttribute("message", message);
           playlist = PlaylistDB.selectPlaylist(user);
           request.setAttribute("playlist", playlist);
           url ="/Playlist.jsp";
       }
        if(action.equals("Rename playlist")){
            updatePlaylist(request,response);
              String message ="Playlist renamed";
           request.setAttribute("message", message);
           playlist = PlaylistDB.selectPlaylist(user);
           request.setAttribute("playlist", playlist);
           url ="/Playlist.jsp";
        }
          getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    
    private void createPlaylist(HttpServletRequest request, HttpServletResponse response, long ID){
            String playlistName = request.getParameter("playlistName");
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
           Playlist playlist = new Playlist();
           playlist.setCreated(date);
           playlist.setName(playlistName);
           playlist.setCreated(date);
           PlaylistDB.addPlaylist(playlist, ID);
    }
    private void deletePlaylist(HttpServletRequest request, HttpServletResponse response){
           String ID = request.getParameter("playlistID");
           long playlistID = Long.parseLong(ID);
           PlaylistDB.deletePlaylist(playlistID);
    }
    private void updatePlaylist(HttpServletRequest request, HttpServletResponse response){
        String ID = request.getParameter("playlistID");
        long playlistID = Long.parseLong(ID);
        String Name = request.getParameter("renamePlaylist");
        Playlist playlist = new Playlist();
        playlist.setName(Name);
        playlist.setPlaylistID(playlistID);
        PlaylistDB.updatePlaylist(playlist);
    }
}