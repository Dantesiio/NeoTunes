package model;

import java.util.ArrayList;

public class PlayList {
    
    private String namePlaylist;
    private String id;
    private ArrayList<Audio> audios;

    /**
     * Constructor de playlist
     * @param namePlaylist
     */
    public PlayList(String namePlaylist) {
        this.namePlaylist = namePlaylist;
      
      
    }
    public String getNamePlaylist() {
        return namePlaylist;
    }
    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public boolean addAudio(Audio audioData) {
        audios.add(audioData);
        return true;
    }
    public boolean removeAudio(Audio audioData) {
        audios.remove(audioData);
        return true;
    }
    public String toString() {
        return "PlayList [namePlaylist=" + namePlaylist + ", id=" + id + "]";
    }

    
}