package model;

import java.time.LocalDate;

public class User {
    
    
    private String nickName;
    private String document;
    private LocalDate date;

    
      
   /**
    * Constructor Usuario
    * @param date
    */
    public User(String nickName, String document, LocalDate date) {
        
        this.nickName=nickName;
        this.document=document;
        this.date=date;

    }
    


//GETTERS AND SETTERS
    public String getNickName() {
        return nickName;
    }


    public String getDocument() {
        return document;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public void setDocument(String document) {
        this.document = document;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    

}