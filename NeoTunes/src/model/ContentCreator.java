package model;

import java.time.LocalDate;

public class ContentCreator extends Producer{
/**
 * Metodo constructor de el creador
 * @param nickName
 * @param cedula
 * @param date
 * @param name
 * @param imageProducerUrl
 */
    public ContentCreator(String nickName, String cedula, LocalDate date, String name, String imageProducerUrl) {
           super(nickName, cedula, date, name, imageProducerUrl);
    }
}