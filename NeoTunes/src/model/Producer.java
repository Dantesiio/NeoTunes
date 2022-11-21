package model;

import java.time.LocalDate;

public class Producer extends User {

   private String name;
   private String imageProducerUrl;

   /*
    * se desea saber el número acumulado de reproducciones y el total de tiempo reproducido por los usuarios consumidores.
    */
/**
 * Constructor de el productor
 * @param nickName
 * @param cedula
 * @param date
 * @param name
 * @param imageProducerUrl
 */
    public Producer(String nickName, String cedula, LocalDate date, String name, String imageProducerUrl) {
        super(nickName, cedula, date);
        this.name=name;
        this.imageProducerUrl=imageProducerUrl;
    }
// GeTTER AND SETTER
    public String getName() {
        return name;
    }

    public String getImageProducerUrl() {
        return imageProducerUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageProducerUrl(String imageProducerUrl) {
        this.imageProducerUrl = imageProducerUrl;
    }

    
}