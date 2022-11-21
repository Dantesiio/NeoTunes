package model;

public class Podcast extends Audio{


    private String description;
    private TypeCategory category;
    private String urlImage;
    
/**
 * Constructor Podcaast
 * @param name
 * @param description
 * @param category
 * @param urlImage
 * @param duration
 */
public Podcast(String name, double duration, int numberOfReprodution, String description,TypeCategory category, String urlImage) {
    super(name, duration, numberOfReprodution);
    this.description = description;
    this.category = category;
    this.urlImage = urlImage;
}
   




    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public TypeCategory getCategory() {
        return category;
    }


    public void setCategory(TypeCategory category) {
        this.category = category;
    }


    public String getUrlImage() {
        return urlImage;
    }


    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    
}