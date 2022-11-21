package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Premium extends Consumer {
    private ArrayList<Song> songsPremium;
    private ArrayList<PlayList> playListPremium;
    /*todo el catalogo
     * canciones ilimitadas
     * listas de reproduccion ilimitadas
     */
    /**
     * Constructor usuario premium
     * @param nickName
     * @param cedula
     * @param date
     */
    public Premium(String nickName, String cedula, LocalDate date) {
           super(nickName, cedula, date);
           songsPremium= new ArrayList<Song>();
           playListPremium= new ArrayList<PlayList>();
    }
    
    public ArrayList<Song> getSongsPremium() {
        return songsPremium;
    }

    public void setSongsPremium(ArrayList<Song> songsPremium) {
        this.songsPremium = songsPremium;
    }

    public ArrayList<PlayList> getPlayListPremium() {
        return playListPremium;
    }

    public void setPlayListPremium(ArrayList<PlayList> playListPremium) {
        this.playListPremium = playListPremium;
    }
    /**
     * Reproduce el audip para los premium sin anuncios
     * @param positionAudio
     * @param songs
     * @return
     */
    public String playAudio(int positionAudio,ArrayList<Song> songs){
       
        String message = "";
        for (int i = 0; i < songs.size(); i++) {
            int index =(int)(Math.random()*(3-1))+1;
            if(songs.get(positionAudio)instanceof Song){
                    message="playing.." + songs.get(index).getName()+"...in Neotunes\n";
   
            }   
        }

        return message;

    }

}