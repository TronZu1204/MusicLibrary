/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

import LibraryClass.User;
/**
 *
 * @author GIGABYTE
 */
public class UserDB {
    public static void insertUser(User user){
        EntityManager em = DButil.getFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
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
    
    public static List<User> selectUser(String email,String pass){
    EntityManager em = DButil.getFactory().createEntityManager();
    String qString = "Select u FROM User u " + "WHERE u.gmail = :email AND" +" u.pass = :pass";
    TypedQuery<User> q = em.createQuery(qString, User.class);
    q.setParameter("email", email);
    q.setParameter("pass", pass);
    List<User> user = null;
    try{
        user = q.getResultList();
        return user;
    }
    catch (NoResultException e){
        return null;
    }
    finally{
        em.close();
    }  
} 

public static boolean userExist(String email, String pass){
   List<User> u = selectUser(email, pass);
   return !u.isEmpty();
}
}
