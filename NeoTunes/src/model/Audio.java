package model;

public class Audio {
    private String name;
    private double duration;
    private int numberOfReprodution;
    public Audio(String name, double duration, int numberOfReprodution) {
        this.name = name;
        this.duration = duration;
        this.numberOfReprodution = numberOfReprodution;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public int getNumberOfReprodution() {
        return numberOfReprodution;
    }
    public void setNumberOfReprodution(int numberOfReprodution) {
        this.numberOfReprodution = numberOfReprodution;
    }
    
}
