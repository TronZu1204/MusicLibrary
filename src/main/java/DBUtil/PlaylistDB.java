/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import LibraryClass.Playlist;
import LibraryClass.User;
import java.util.List;
import javax.persistence.NoResultException; 
import javax.persistence.TypedQuery;
/**
 *
 * @author GIGABYTE
 */
public class PlaylistDB {
    public static void addPlaylist(Playlist playlist,long user){
        EntityManager em = DButil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        User owner = em.find(User.class,user);
        playlist.setUser(owner);
        trans.begin();
        try {
            em.persist(playlist);
            trans.commit();
        }
        catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static List<Playlist> selectPlaylist(User userID){
         EntityManager em = DButil.getFactory().createEntityManager();
    String qString = "Select u FROM Playlist u " + "WHERE u.user = :id";
    TypedQuery<Playlist> q = em.createQuery(qString, Playlist.class);
    q.setParameter("id", userID);
    List<Playlist> playlist = null;
    try{
        playlist = q.getResultList();
        return playlist;
    }
    catch (NoResultException e){
        return null;
    }
    finally{
        em.close();
    }  
    }
    public static void deletePlaylist(long playlistID){
        EntityManager em = DButil.getFactory().createEntityManager();
        Playlist removeplaylist = em.find(Playlist.class, playlistID);
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.remove(em.merge(removeplaylist));
            trans.commit();
        }
        catch(Exception e){
            System.out.println(e);
            trans.rollback();     
        }
        finally {
            em.close();
        }
    }
    public static void updatePlaylist(Playlist newPlaylist){
         EntityManager em = DButil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        Playlist oldPlaylist = em.find(Playlist.class, newPlaylist.getPlaylistID());
        try{
            oldPlaylist.setName(newPlaylist.getName());
             em.merge(oldPlaylist);
            trans.commit();
        }
        catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }
        em.close();
    }
}
