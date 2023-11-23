/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Webservlet;

import DBUtil.MusicDB;
import DBUtil.PlaylistDB;
import DBUtil.UserDB;
import LibraryClass.Music;
import LibraryClass.Playlist;
import LibraryClass.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIGABYTE
 */
public class searchServlet extends HttpServlet {

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
            out.println("<title>Servlet searchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/browse.jsp";
        String action = request.getParameter("action");
        if(action.equals("search")){
            SearchMusic(request,response);
            SearchPlaylist(request,response);
        }
        if (action.equals("View playlist")) {
            Long playlistID = Long.parseLong(request.getParameter("playlistID"));
            //get the selected playlist
            Playlist selectedPlaylist = PlaylistDB.selectPlaylistByID(playlistID);
            request.setAttribute("selectedPlaylist", selectedPlaylist);
            //get the songs in the playlist
            Set<Music> selectedPlaylistSongs = MusicDB.selectMusicInPlaylist(playlistID);
            request.setAttribute("selectedPlaylistSongs", selectedPlaylistSongs);
            //get playlist owner's name
            User playlistOwner = selectedPlaylist.getUser();
            String playlistOwnerName = UserDB.selectUserNameFromID(playlistOwner.getUserID());
            request.setAttribute("playlistOwnerName", playlistOwnerName);
            url = "/playlistDetails.jsp";
        }
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    private static void SearchMusic(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        String pattern = request.getParameter("songSearch");
        pattern = URLEncoder.encode( pattern, "ISO-8859-1" );
        pattern = URLDecoder.decode( pattern, "UTF-8" );
        List<Music> result = MusicDB.findMusic(pattern);
        request.setAttribute("songResults", result);
        request.setAttribute("pattern", pattern);
    }
     private static void SearchPlaylist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        String pattern = request.getParameter("songSearch");
        pattern = URLEncoder.encode( pattern, "ISO-8859-1" );
        pattern = URLDecoder.decode( pattern, "UTF-8" );
        List<Playlist> result = PlaylistDB.findPlaylist(pattern);
        request.setAttribute("playlistResults", result);
    }
}
