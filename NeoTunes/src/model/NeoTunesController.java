package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class NeoTunesController {

    //Relations
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<PlayList> playLists;
    private ArrayList<Song> songs;
    private ArrayList<Podcast> podcasts;
    
    

    public NeoTunesController() {
        users= new ArrayList<User>();
        songs= new ArrayList<Song>();
        podcasts= new ArrayList<Podcast>();
        audios = new ArrayList<Audio>();
    }

/**
 * Metodo utilizado para encontra un usuario por su nickname
 * @param document
 * @return usuario
 */
    public User searchUserobj(String nickName){
       User objUser= null;
       boolean exist=true;
       
       for (int i = 0; i < users.size() && exist ; i++) {
            if(users.get(i).getNickName().equals(nickName)){
                exist=false;
                objUser = users.get(i);
            } 
       }

       return objUser;
    }
    /**
     * encontrar usuario por su documento
     * @param document
     * @return
     */
    public boolean searchUser(String document){
        User objUser= null;
        boolean exist=false;
        
        for (int i = 0; i < users.size() && !exist ; i++) {
             if(users.get(i).getDocument ().equals(document)){
                 exist=true;
                 objUser = users.get(i);
             } 
        }
 
        return exist;
     }
/**
 * añadir Usuario estandar o premium, validando que su documento no se repita
 * @param nickName recibe el nombre
 * @param document recibe el documento
 * @param date recibe la fecha en que ingresa
 * @param option seleccion usuario estandar y premium
 * @return
 */
    public String addUser(String nickName, String document, LocalDate date, int option){
        
        String message="";
        boolean confirm=searchUser(document);
       
        
        if(!confirm && option==1){
             Standard objStandard= new Standard(nickName, document, date);
            users.add(objStandard);
            message="The standard user was created successfully.";
        }
        else if(!confirm && option==2){
            Premium objPremium= new Premium(nickName, document, date);
            users.add(objPremium); 
            message="The premium user was created successfully."; 
        }
        else if(confirm){
            message="It could not be created because there is already someone with this same document.";
        }
      return message;
    }
    
/**
 * metodo para añadir un usuario artista o creador, validando que no este registrado ya el
 * documento
 * @param nickName
 * @param document
 * @param date
 * @param name
 * @param imageProducerUrl
 * @param option
 * @return
 */
    public String addUser(String nickName, String document, LocalDate date, String name, String imageProducerUrl, int option){
        String message="";

        boolean confirm=searchUser(document);
        
        if(!confirm && option==1){
            Artist objArtist= new Artist(nickName, document, date, name, imageProducerUrl);
            users.add(objArtist);
            message="The Artist user was created successfully.";
        }
        else if(!confirm && option==2){
            ContentCreator objContentCreator= new ContentCreator(nickName, document, date, name, imageProducerUrl);
            users.add(objContentCreator);
            message="The creator user was created successfully.";
        }
        else if(confirm){
            message="It could not be created because there is already someone with this same document.";
        }
        return message;
    }

    /**
     * Metodo utilizado para añadir canciones
     * @param name nombre de la cancion
     * @param album nombre de el album
     * @param option 
     * @param urlCover url de la cancion
     * @param duration duracion de la cancion
     * @param value valor de la cancion
     * @param numberOfReproduction numero de reproduction
     * @param numberOfSell numero de ventas
     * @return
     */
    public String addSong (String name, String album, int option,String urlCover, double duration, double value, int numberOfReprodution,int numberOfSell){
        String messsage="The song was created correctly";

        TypeGender gender = null;
		if (option == 1) {
			gender = TypeGender.ROCK;

		} else if (option == 2) {
			gender = TypeGender.POP;

		} else if (option == 3) {
			gender = TypeGender.TRAP;

		} else if (option == 4) {
			gender = TypeGender.HOUSE;
		}

        Song objSong= new Song(name, duration, numberOfReprodution, album, gender, urlCover, value, numberOfSell);
        songs.add(objSong);
        
        return messsage;
    }

/**
 * metodo utilizado para añadir podcast
 * @param name
 * @param description
 * @param option
 * @param urlImage
 * @param duration
 * @param numberOfReprodution
 * @return
 */
    public String addPodcast(String name,String description, int option, String urlImage, double duration, int numberOfReprodution){
        String messsage="The podcast was created correctly";
        
        TypeCategory category = null;
		if (option == 1) {
			category = TypeCategory.POLITIC;

		} else if (option == 2) {
			category = TypeCategory.ENTERTAIMENT;

		} else if (option == 3) {
			category = TypeCategory.VIDEOGAME;

		} else if (option == 4) {
			category = TypeCategory.FASHION;
		}

        Podcast objPodcast= new Podcast(name, duration, numberOfReprodution, description, category, urlImage);
        podcasts.add(objPodcast);
        return messsage;
    }
    /**
     * genera la matriz 6 * 6
     * @return
     */
    public int[][] matrizSeis(){
        int[][] matriz =new int[6][6];
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[0].length; y++) {
                matriz[x][y] = (int) (Math.random()*(8+1)+1);
            }
           
          }
        return matriz;

    }
    /**
     * imprime la matrix 6 * 6
     * @param matrizSeis
     * @return
     */
    private String printNumericMatrix(int[][] matrizSeis) {
		String print = "";
		for (int i = 0; i < matrizSeis.length; i++) { // filas numbers.length
			for (int j = 0; j < matrizSeis[0].length; j++) { // columnas numbers[0].length
				print += matrizSeis[i][j] + " ";
			}
			print += "\n";
		}

		return print;
	}
    /**
     * metodo para generar codigo identificador
     * @param option
     * @param matriz
     * @return
     */
    public String generateIdentifier(int option,int[][]matriz){

        String code="";

         switch(option){
          case 1:
          for (int i = matriz.length; i > 0; i--) {
            code =code + matriz[i - 1][0];
          }
              for (int i = 1, j = 1; i < matriz.length -1; i++, j++) {           
                code = code + matriz[i][j];        
              }
          for (int i = matriz.length; i > 0; i--) { 
            code = code + matriz[i - 1][matriz[0].length - 1];
          }
           break;
  
          case 2:
          for (int j = 0; j < matriz.length -4; j++) { 
            code=code + matriz[0][j];
          }
          for (int i = 0; i < matriz.length; i++) { 
            code = code + matriz[i][2];
          }
          for (int i = matriz.length; i > 0; i--) { 
            code = code + matriz[i - 1][3];
          }
          for (int j = matriz.length -2; j < matriz.length; j++ ) { 
            code = code + matriz[0][j];
          }
  
           break;
           case 3:
           for (int i=5;i>=0;i--){
              for(int j=5;j>=0;j--){
                  int sum = i+j;
                  if (sum%2!=0){
                      if(sum!=1){
                          code= code + matriz[i][j]+" ";
                      }
                  }
  
              }
          }
           break;
  
  
         }
  
        return code;
    }
    /**
     * metodo para que un usuario pueda crear playlist 
     * @param nickNameToSearch
     * @param namePlaylist
     * @return
     */
    public String createPlaylist(int optionOfConsumer, String nickNameToSearch,String namePlaylist){
        String message= " ";
        User objUser = searchUserobj(nickNameToSearch);
        if (objUser == null ){
            message = "User not found";
        }else{
            PlayList objplaylist= new PlayList(namePlaylist);

            ((Consumer)(objUser)).addPlaylist(objplaylist);
            users.remove(objUser);
            users.add(objUser);
            message = "Playlist has been created";
        }
      return message;  
    }
   /**
    * Se añade una cancion a la playlist
    * @param index posicion
    * @param nickname nombre de usuario al que se añade
    * @return
    */
    public String addSongToPlaylist(int index, String nickname) {

        Audio audioData = songs.get(index-1);
        String message = "";
        int option = 0;

        User user =  searchUserobj(nickname);
        if (option ==1){

            if (user instanceof Standard && user !=null){
                Standard userStandard = (Standard)user;
                userStandard.addAudioToPlaylist(index, audioData);
                message ="The song has been upload";

            }else if(user instanceof Premium && user !=null){
                Premium userPremium= (Premium)user;
                userPremium.addAudioToPlaylist(index, audioData);
                message ="the song has been upload";

            }else{
                message = "the song doesnt exist";}
        } else if (option==2){
            if (user instanceof Standard && user !=null){
                Standard userStandard = (Standard)user;
                userStandard.removeAudioToPlaylist(index, audioData);
                message ="The song has been remove";
        
            }else if(user instanceof Premium && user !=null){
                Premium userPremium= (Premium)user;
                userPremium.removeAudioToPlaylist(index, audioData);
                message ="the song has been remove";
        
            }else{
                message = "the song doesnt exist";

            } 
        }
            return message;
    }
/**
 * añade las canciones a la playlist
 * @param nickName
 * @param option
 * @param namePlay
 * @param audioName
 * @return
 */
    public String printPlaylist(String nickName, int option, String namePlay, String audioName) {
        String message = "";
        PlayList objPlayList; 
        User objUser = searchUserobj(nickName);
        Audio objAudio = searchAudio(audioName);
        if(objAudio!=null){ 
            if (option ==1){ // Este condicional valida la accion 1 es agregar, 2 es borrar
                if (objUser instanceof Consumer &&  objUser !=null){ // este condicional valida que el usuario exista y sea de tipo consumidor
                    objPlayList = searchPlayListfromUser(objUser, namePlay); // esta variable guarda la playlist a la cual se le quiere agregar el audio
                    if(objPlayList!=null){  // este condicional valida que la playlist exista
                        Consumer userConsumer = (Consumer)objUser; // en esta variable se convierte al usuario a tipo consumidor
                        userConsumer.addAudioToPlaylist(userConsumer.getObPlayList().indexOf(objPlayList), objAudio); // agrego el audio
                        users.remove(userConsumer);
                        users.add(userConsumer);
                        message ="The song has been uploaded";
                    }else{
                        message = "The playlist was not found";
                    }
                }else{
                    message = "the user doesnt exist";
                }
            }else if (option==2){ // borrar audio
                if (objUser instanceof Consumer && objUser !=null){ // verifico que el usuario sea consumidor y no sea nula
                    objPlayList = searchPlayListfromUser(objUser, namePlay); // esta variable guarda la playlist a la cual se le quiere agregar el audio
                    if(objPlayList!=null){  // este condicional valida que la playlist exista
                        Consumer userConsumer = (Consumer)objUser; // en esta variable se convierte al usuario a tipo consumidor
                        userConsumer.removeAudioToPlaylist(userConsumer.getObPlayList().indexOf(objPlayList), objAudio); //borro el audio
                        users.remove(userConsumer); // borro el usuario viejo
                        users.add(userConsumer); // agrego el usuario nuevo con los cambios
                        message ="The song has been removed \n";
                    }
                }else{
                    message = "the user doesnt exist";
                }
            }
        }else{
            message = "audio was not found";
        }
        return message;
    }
    /**
     * busca el audio si existe
     * @param audioName
     * @return
     */
    public Audio searchAudio(String audioName){
        Audio objAudio = null;
        boolean isFound = false;
        for (int i = 0; i < podcasts.size() && !isFound; i++) {
            if(podcasts.get(i).getName().equals(audioName)){
                objAudio = podcasts.get(i);
                isFound = true;
            }
        }
        if(!isFound){
            for (int i = 0; i < songs.size() && !isFound; i++) {
                if(songs.get(i).getName().equals(audioName)){
                    objAudio = songs.get(i);
                    isFound = true;
                }
            }   
        }
        return objAudio;

    }
    /**
     * guarda playlist a la cual se le quiere agregar el audio
     * @param objUser
     * @param namePlay
     * @return
     */
    public PlayList searchPlayListfromUser(User objUser, String namePlay){
        PlayList objList = null;
        boolean isFound = false;
        if(objUser instanceof Consumer){
            Consumer userConsumer = (Consumer)objUser;
            for (int i = 0; i < userConsumer.getObPlayList().size() && !isFound; i++){ 
                if(userConsumer.getObPlayList().get(i).getNamePlaylist().equals(namePlay)){
                    objList = userConsumer.getObPlayList().get(i);
                }
            }
        }
        return objList;

    }
    /**
     * imprime la lista de podcast
     * @return
     */
    public String printPodcast() {
        String message = "";
        int x=0;
        for (int i = 0; i < podcasts.size(); i++) {
            x++;
            message += x +". "+ podcasts.get(i).toString();
        }
        return message;
    }

/**
 * imprime la lista de canciones
 * @return
 */
    public String printSong() {
        String message = "";
        int x=0;
        for (int i = 0; i < songs.size(); i++) {
            x++;
            message += x +". "+ songs.get(i).toString();
        }
        return message;
    }
    /**
     * comprar canciones
     * @param Song
     * @param nameUser
     * @return
     */
    public String buySong(int Song, String nameUser){
        String message="Couldn't make the purchase";
        Song songBought=songs.get(Song-1);
        String nameSong=songBought.getName();

        User user=searchUserobj(nameUser);
         if(user!= null && user instanceof Standard){

            Standard userStandard=(Standard)user;
            boolean stop=false;
            for (int i = 0; i < 100 &&!stop; i++) {
                if(userStandard.getSongsStandard()[i]==null){
                    userStandard.getSongsStandard()[i] =songBought;
                    stop=true;
                    message="the purchase of the song "+nameSong+ " for the standard user has been successful";
                }
            }
         } 
         
         else if(user!= null && user instanceof Premium){
            Premium userPremium=(Premium)user;
            userPremium.getSongsPremium().add(songBought);
            message="the purchase of the song "+nameSong+ " for the premium user has been successful";
         }

        return message;

    }
    /**
     * reprduce el audio
     * @param nickname
     * @param audioSelected
     * @return
     */
    public String reproduceAudio(String nickname,int audioSelected) {
        String message="";
        audioSelected+=-1;
        User objUser=searchUserobj(nickname);

          if(objUser instanceof Standard){
             Standard objStandard= (Standard)objUser;
                message=objStandard.playAudio(audioSelected, songs);
          }
          else if(objUser instanceof Premium){
             Premium objPremium= (Premium)objUser;
             message= objPremium.playAudio(audioSelected, songs);
          }
          
        return message;
        }
        /**
         * genera la id para compartir la playlist
         * @param nameUser
         * @param optionPlaylist
         * @return
         */
        public String sharePlaylist(String nameUser, int optionPlaylist){

            String message="The option is invalid";
            User objUser=searchUserobj(nameUser);
      
            if(objUser instanceof Standard){
              Standard objStandard= (Standard)objUser;
              int matriz[][]=matrizSeis();
              
              message="The name of the playlist is: "+objStandard.getPlayListStandard()[optionPlaylist-1].getNamePlaylist()+ " and the id is :"+ objStandard.getPlayListStandard()[optionPlaylist-1].getId()+"\n\nMatriz: \n"+printNumericMatrix(matriz);
              
            }
            else if(objUser instanceof Premium){
              Premium objPremium= (Premium)objUser;
              int matriz[][]=matrizSeis();
              message="Then name of the playlist is: "+objPremium.getPlayListPremium().get(optionPlaylist-1).getNamePlaylist() +" and the id is :"+objPremium.getPlayListPremium().get(optionPlaylist-1).getId()+"\n\nMatriz: \n"+printNumericMatrix(matriz);
            }
            return message;
      }
      /**
       * impirme la playlist
       * @param nameUser
       * @return
       */
      public String printPlaylistTWO(String nameUser){
        String message="The playlists of the user are: \n"; 
        User user=searchUserobj(nameUser);
         if(user instanceof Standard){
             Standard userStandard= (Standard)user;
             int k=0;
                for (int i = 0; i < 20 && userStandard.getPlayListStandard()[i] !=null; i++) {
                    
                    k++;
                     message+=k+". "+userStandard.getPlayListStandard()[i].toString();
                    
                }  
         }
         else if(user instanceof Premium){
            Premium userPremium= (Premium)user;
            int l=0;
            for (int i = 0; i < userPremium.getPlayListPremium().size(); i++) {
                 l++;
                 message+=l+". "+userPremium.getPlayListPremium().get(i).toString();
            }
         }
         else{
             message="The user doesn't exist";/** */
         }
        return message;
        }
}
