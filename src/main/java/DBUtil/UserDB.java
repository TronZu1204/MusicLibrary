/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
}
