/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryClass;

import java.util.Date;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author GIGABYTE
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long userID;
     private String name;
     private String pass;
     private String infor;
     private String gmail;
     private int phoneNumber;
     private String image;
     @Temporal(TemporalType.DATE)
     private Date created;
     @OneToMany(mappedBy = "havePlaylist")
     private Set<Playlist> playlist;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Set<Playlist> playlist) {
        this.playlist = playlist;
    }
     
}
