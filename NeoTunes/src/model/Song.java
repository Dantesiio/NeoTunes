package model;

public class Song extends Audio {
    private String album;
    private TypeGender gender;
    private String urlCover;
    private double value;
    private int numberOfSell;
    public Song(String name, double duration, int numberOfReprodution, String album, TypeGender gender,
            String urlCover, double value, int numberOfSell) {
        super(name, duration, numberOfReprodution);
        this.album = album;
        this.gender = gender;
        this.urlCover = urlCover;
        this.value = value;
        this.numberOfSell = numberOfSell;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public TypeGender getGender() {
        return gender;
    }
    public void setGender(TypeGender gender) {
        this.gender = gender;
    }
    public String getUrlCover() {
        return urlCover;
    }
    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int getNumberOfSell() {
        return numberOfSell;
    }
    public void setNumberOfSell(int numberOfSell) {
        this.numberOfSell = numberOfSell;
    }
    @Override
    public String toString() {
        return "Song [name=" +super.getName() + ", album=" + album + ", gender=" + gender + ", value=" + value + ", numberOfSell="
                + numberOfSell + "]";
    }
    

}