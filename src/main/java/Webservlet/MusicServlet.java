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

import LibraryClass.Music;
import DBUtil.MusicDB;
import LibraryClass.User;

/**
 *
 * @author Johnny
 */
@WebServlet(name = "MusicServlet", urlPatterns = {"/music"})
public class MusicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //default return path
        String url = "/index.jsp";
        //get action
        String action = request.getParameter("action");

        //get current logged in User info
        User user = (User) request.getSession().getAttribute("loggeduser");
        long authorID = user.getUserID();

        //get all uploaded music by this user
        //List<Music> userUploadedMusicList = MusicDB.selectMusicbyUserID(authorID));
        
        //upload a song, author is set to current logged in user
        if (action.equals("createMusic")) {
            String message;
            try {
                createMusic(request, response);
                message = "Uploaded song successfully!";
                //add this new song to the userUploadedMusicList
                //List<Music> userUploadedMusicList = MusicDB.selectMusicbyUserID(authorID));
                //request.setAttribute("userUploadedMusicList", userUploadedMusicList);
            }
            catch (Exception e) {
                message = "Failed to upload song!";
                System.out.println("Failed to upload song!");
            }
            
            request.setAttribute("message", message);
            //return back to profile.jsp after uploading a song (new song is displayed there)
            //should change this to a playlist url that is dedicated for uploaded songs
            url = "/profile.jsp";
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void createMusic(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("musicName");
        String category = request.getParameter("musicCategory");
        int liked = 0;
        int listen = 0;

        String placeholder = request.getParameter("musicAuthor");
        long authorID = Long.parseLong(placeholder);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        //default image_path to empty
        String image = "";

        Music music = new Music(name, category, liked, listen, image, date);
        MusicDB.insertMusic(music, authorID);
    }
}
