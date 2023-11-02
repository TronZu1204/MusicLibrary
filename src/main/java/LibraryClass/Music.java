/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryClass;
import java.util.Date;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author GIGABYTE
 */
@Entity
public class Music implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long musicID;
    private String name;
    @ManyToOne
    private User author;
    private String category;
    private int like;
    private int listen;
    private String image;
    @Temporal(TemporalType.DATE)
    private Date created;
    @ManyToMany
    private Set<Playlist> inPlaylist;
    
    public Music(){
        
    }
    public Music(long musicID, String name, User author, String category, int like, int listen, String image, Date created, Set<Playlist> inPlaylist) {
        this.musicID = musicID;
        this.name = name;
        this.author = author;
        this.category = category;
        this.like = like;
        this.listen = listen;
        this.image = image;
        this.created = created;
        this.inPlaylist = inPlaylist;
    }
    
    

    public long getMusicID() {
        return musicID;
    }

    public void setMusicID(long musicID) {
        this.musicID = musicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getListen() {
        return listen;
    }

    public void setListen(int listen) {
        this.listen = listen;
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

    public Set<Playlist> getInPlaylist() {
        return inPlaylist;
    }

    public void setInPlaylist(Set<Playlist> inPlaylist) {
        this.inPlaylist = inPlaylist;
    }
    
}
