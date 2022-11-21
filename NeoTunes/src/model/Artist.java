package model;

import java.time.LocalDate;

public class Artist extends Producer {

    /**
     * Constructor artista
     * @param nickName
     * @param cedula
     * @param date
     * @param name
     * @param imageProducerUrl
     */
    public Artist(String nickName, String cedula, LocalDate date, String name, String imageProducerUrl) {
        super(nickName, cedula, date, name, imageProducerUrl);

    }
}