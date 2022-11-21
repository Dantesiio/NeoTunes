package ui;

import java.util.Scanner;

import java.time.LocalDate;
import model.NeoTunesController;

import model.User;

public class NeoTunesApp {

    // Relations
    private NeoTunesController shop;

    public static Scanner lector = new Scanner(System.in);

    public NeoTunesApp() {

        shop = new NeoTunesController();
    }
/**
 * Metodo main donde se ejecutan todas las funciones del codigo
 * @param args
 */
    public static void main(String args[]) {
        NeoTunesApp objMain = new NeoTunesApp();
        objMain.menu();
        
       
        

    }

    public void menu() {

        int option = 0;

        while (option != 10) {
            System.out.println(" == Menu == ");
            System.out.println("1. Register consumer users.");
            System.out.println("2. Register producer users.");
            System.out.println("3. Create a song or podcast.");
            System.out.println("4. Create a playlist.");
            System.out.println("5. Edit a playlist.");
            System.out.println("6. Share a playlist.");
            System.out.println("7. Play a song or podcast");
            System.out.println("8. Buy a song");
            System.out.println("9. Generar informes con los datos registrados");
            System.out.println("10. Exit menu.");

           

            option = lector.nextInt();
            lector.nextLine();

            switch (option) {

                case 1:
                    registerConsumer();
                    break;

                case 2:
                    registerProducer();
                    break;

                case 3:
                    createSongOrPodcast();
                    break;

                case 4:
                    createPlaylist();

                    break;

                case 5:
                    editPlaylist();

                    break;

                case 6:
                    sharePlaylist();

                    break;

                case 7:
                    reproducer();

                    break;

                case 8:
                    buyASong();
                    break;

                case 9:

                    break;
                
             
                
                case 10:
                     System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Option out of range.");
                    break;
            }
        }

    }

//METODOS de registro
    public void registerConsumer(){

       System.out.println("Select the type of consumer\n1. Standard.\n2. Premium.");
        int option = lector.nextInt();
        lector.nextLine();

        System.out.println("Please type the nickname");
        String nickname = lector.nextLine();

      System.out.println("Please type the document");
        String document = lector.nextLine();

        LocalDate vinculationDate= LocalDate.now();
       
        System.out.println(shop.addUser(nickname, document, vinculationDate, option));

    }
    
     public void registerProducer(){
        System.out.println("Select the type of producer\n1. Artist.\n2. Content creator.");
            int option= lector.nextInt();
            lector.nextLine();

        System.out.println("Please type the nickname");
            String nickName= lector.nextLine();
           
            System.out.println("Please type the document");
            String document = lector.nextLine();  
            
            LocalDate dateProducer= LocalDate.now();
             
            System.out.println("Please type the name");
            String name=lector.nextLine();

            System.out.println("Please type the url");
            String imageUrl=lector.nextLine();

        System.out.println(shop.addUser(nickName, document, dateProducer, name, imageUrl, option));
    }
 // registro de canciones or podcast
    public void createSongOrPodcast(){
        System.out.println("Select one:\n1. Song\n2. Podcast");
            int option = lector.nextInt();
            lector.nextLine();
        
        System.out.println("Please type the name of user");
            String name = lector.nextLine();
        
        if(option==1){
            System.out.println("Type the name of the album");
            String album = lector.nextLine();
            
            System.out.println("Select a gender.\n1. Rock\n2. Pop.\n3. Trap.\n4. House.");
            int optionGender= lector.nextInt();
            lector.nextLine();

            System.out.println("Type the url of the cover");
            String cover=lector.nextLine();

            System.out.println("Please type the duration");
            double duration = lector.nextDouble();
            lector.nextLine();

            System.out.println("Type the value of the song");
            double value= lector.nextDouble();
            lector.nextLine();

            System.out.println(shop.addSong(name, album, optionGender, cover, duration, value, option, option));
            //numero de reproducciones
            //numero de veces vendidas
        }
        else if(option==2){

            System.out.println("Please type a description");
            String description = lector.nextLine();
            
            System.out.println("Select a category.\n1. Politic.\n2. Entertainment.\n3. Videogames.\n4. Fashion.");
            int optionCategory= lector.nextInt();
            lector.nextLine();

            System.out.println("Please type the url of the image");
            String urlImagePodcast=lector.nextLine();

            System.out.println("Please type the duration");
            double duration = lector.nextDouble();
            lector.nextLine();
            System.out.println(shop.addPodcast(name, description, optionCategory, urlImagePodcast, duration, option));
            //NUMERO DE REPRODUCCIONES EN LA CONTROLER YA Q AQUI ES 0

        }
    }
    //crear playlist
    public void createPlaylist(){
        System.out.println("please type the nickname");
        String nickName=lector.nextLine();
        System.out.println("name of Playlist ");
        String namePlaylist=lector.nextLine();
        System.out.println(shop.createPlaylist(0, nickName, namePlaylist));
    }
    public void editPlaylist(){
        System.out.println("The user name");
        String nickName=lector.nextLine();
        System.out.println("type playlist name");
        String namePlay=lector.nextLine();
        System.out.println("Select action");
        System.out.println("1) add");
        System.out.println("2) delete");
        int option=lector.nextInt();
        lector.nextLine();
        System.out.println("type audio name");
        String audioName=lector.nextLine();
        System.out.println(shop.printPlaylist(nickName, option, namePlay, audioName));
    }
    public void buyASong(){

        System.out.println("type the name of the user");
            String user=lector.nextLine();
            User confirmExist=shop.searchUserobj(user);

            if(confirmExist!=null){
                System.out.println(shop.printSong());
                System.out.println("Please, select the song to buy");
                int songToBuy=lector.nextInt();
                System.out.println(shop.buySong(songToBuy, user));
            }
            else{
                System.out.println("The user doesn't exist");
            }
    }
    //Reproduce a audio
    public void reproducer(){

        System.out.println("Type the nickname of the user");
            String nickname=lector.nextLine();
            User exist=shop.searchUserobj(nickname);

            if(exist!=null){
               System.out.println("Choose a song to reproduce");
               System.out.println(shop.printSong()); 
               System.out.println("Select one");
               int songSelected= lector.nextInt();
               lector.nextLine();
                    System.out.println(shop.reproduceAudio(nickname,songSelected));         
            }
            else{
                System.out.println("The user doesn't exist");
            }
    }
    // Share a playlist
    public void sharePlaylist(){

        System.out.println("enter the nickName that will share the playlist");
           String nickName =lector.nextLine();
           User exist=shop.searchUserobj(nickName);

           if(exist!=null){
             System.out.println("What playlist do you want to share?");
             System.out.println(shop.printPlaylistTWO(nickName)); 
             int playlistSelect= lector.nextInt();
             lector.nextLine();  
             System.out.println(shop.sharePlaylist(nickName, playlistSelect)); 
           }
           else{
            System.out.println("The user doesn't exist");
        }
    }
}
