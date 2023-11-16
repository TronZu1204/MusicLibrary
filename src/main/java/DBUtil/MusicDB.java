/**
 *
 * @author Johnny
 */
package DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

import LibraryClass.Music;
import LibraryClass.User;

public class MusicDB {
    public static boolean insertMusic(Music music) {
        boolean insertSuccess = false;
        EntityManager em = DButil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(music);
            trans.commit();
            insertSuccess = true;
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
            return insertSuccess;
        }
    }
    
    public static List<Music> selectMusicByMusicID(long MusicID) {
        EntityManager em = DButil.getFactory().createEntityManager();
        String qString = "SELECT u FROM Music u " + "WHERE u.musicid = :MusicID";
        TypedQuery<Music> q = em.createQuery(qString, Music.class);
        q.setParameter("MusicID", MusicID);
        List<Music> music = null;
        
        try {
            music = q.getResultList();
            return music;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
    }
    
    public static List<Music> selectMusicbyUserID(User userID) {
        EntityManager em = DButil.getFactory().createEntityManager();
        String qString = "SELECT u FROM Music u " + "WHERE u.author = :id";
        TypedQuery<Music> q = em.createQuery(qString, Music.class);
        q.setParameter("id", userID);
        List<Music> music = null;
        
        try {
            music = q.getResultList();
            return music;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
    }
    
    public static boolean musicExist(long MusicID) {
        List<Music> u = selectMusicByMusicID(MusicID);
        return !u.isEmpty();
    }
    
    public static boolean updateMusic(Music music) {
        EntityManager em = DButil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        Music updated = em.find(Music.class, music.getMusicID());
        try{
            updated.setName(music.getName());
            updated.setAuthor(music.getAuthor());
            updated.setCategory(music.getCategory());
            updated.setImage(music.getImage());
            em.merge(updated);
            trans.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return false;
        }
        finally {
            em.close();
        }
    }
    
    public static void deleteMusic(long MusicID){
        EntityManager em = DButil.getFactory().createEntityManager();
        Music removedMusic = em.find(Music.class, MusicID);
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove( em.merge(removedMusic));
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();  
        }
        finally {
            em.close();
        }
    }
}
