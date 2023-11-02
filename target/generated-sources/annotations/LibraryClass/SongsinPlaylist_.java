package LibraryClass;

import LibraryClass.Music;
import LibraryClass.Playlist;
import LibraryClass.SongsinPlaylist.CompositeKey;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-01T17:23:45")
@StaticMetamodel(SongsinPlaylist.class)
public class SongsinPlaylist_ { 

    public static volatile SingularAttribute<SongsinPlaylist, Music> music;
    public static volatile SingularAttribute<SongsinPlaylist, Playlist> playlist;
    public static volatile SingularAttribute<SongsinPlaylist, CompositeKey> musicList;

}