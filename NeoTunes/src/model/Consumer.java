package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Consumer extends User {
    protected ArrayList<PlayList> obPlayList;

    /*
     *  para cada tipo de contenido, el acumulado de tiempo reproducido, 
     * el género o categoría más escuchado y el artista y creador de contenido más escuchados. 
     */

public ArrayList<PlayList> getObPlayList() {
        return obPlayList;
    }
/**
 * Constructor del consumidor
 * @param objPlayList
 * @return
 */
    public Consumer(String nickName, String document, LocalDate date) { 
       super(nickName, document, date);
       obPlayList = new ArrayList<PlayList>();
        

    }
    /**
     * validacion addicion de playlist
     * @param objPlayList
     * @return
     */
    public boolean addPlaylist(PlayList objPlayList){
        return obPlayList.add(objPlayList);

    }

    public boolean addAudioToPlaylist(int index, Audio audioData) {
        return obPlayList.get(index).addAudio(audioData);
        
    }
    public String showPlaylists(){
        String message="";
        for (int i =0;i<obPlayList.size(); i ++) {
            message += (i+1) + ". " + obPlayList.get(i).getNamePlaylist()+ "\n";
            
        }
        return message;
    }

    public boolean removeAudioToPlaylist(int index, Audio audioData) {
        return obPlayList.get(index).removeAudio(audioData);
  }
    
}