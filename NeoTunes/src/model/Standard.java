package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

public class Standard extends Consumer {

    private Song[] songsStandard;
	private PlayList[] playListStandard;
    /*acceso al catalogo de audio.
     *hasta 20 listas de reproducción.
     *hasta 100 canciones
     */
    /**
     * Constructor de usuario estandar
     * @param nickName
     * @param cedula
     * @param date
     */
    public Standard(String nickName, String cedula, LocalDate date) {
        super(nickName, cedula, date);

    }
    

    public Song[] getSongsStandard() {
        return songsStandard;
    }


    public void setSongsStandard(Song[] songsStandard) {
        this.songsStandard = songsStandard;
    }


    public PlayList[] getPlayListStandard() {
        return playListStandard;
    }


    public void setPlayListStandard(PlayList[] playListStandard) {
        this.playListStandard = playListStandard;
    }
    int spam=0;
    /**
     * METODO utilizados para reproducir la cancion de el usuario estadar
     * @param positionAudio posicion de la cancion
     * @param songs las canciones que se reproducen
     * @return
     */
    public String playAudio(int positionAudio,ArrayList<Song> songs){
       
        String message = "";
        for (int i = 0; i < songs.size(); i++) {
            int index =(int)(Math.random()*(3-1))+1;
            if(songs.get(positionAudio)instanceof Song){
                spam ++;
                if (spam %2==0){
                    message="playing.." + songs.get(index).getName()+"...in Neotunes\n"+sponsor(i);
                }else{
                    message="playing.." + songs.get(index).getName()+"...in Neotunes\n";
                }
            }
        }
        return message;

    }
    /**
     * genera los anuncios para reproducir la cancion
     * @param i
     * @return
     */
    public String sponsor (int i){
        String ad="";
        String ads[]=new String[3];

        ads[0]="Nike - Just Do It.";
        ads[1]="Coca-Cola - Open Happiness.";
        ads[2]="M&Ms - Melts in Your Mouth, Not in Your Hands";
        if (i==1){
            ad+=ads[0];
        }else if(i==2){
            ad+=ads[1];
        }else if(i==3){
            ad+=ads[2];
        }

        return ad;

    }
}