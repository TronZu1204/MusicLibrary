/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBUtil;


import javax.persistence.*;
/**
 *
 * @author GIGABYTE
 */
public class DButil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_MusicLibrary_war_1.0PU");
    
    public static EntityManagerFactory getFactory() {
        return emf;
    }
    
}
