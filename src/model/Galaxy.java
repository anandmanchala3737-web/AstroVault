package model;

public class Galaxy extends CelestialObject{
    private String galaxyType;
    private long estimatedStars;

  public Galaxy(String Type,String name, double mass, double radius, double surfaceGravity, String description,String galaxyType,long estimatedStars){
        super(Type,name,mass,radius,surfaceGravity,description);
        this.galaxyType=galaxyType;
        this.estimatedStars=estimatedStars;
    }

    // GETTER AND SETTER
    // getter
    String getgalaxyType(){
        return this.galaxyType;
    }
    long getestimatedStars(){
        return this.estimatedStars;
    }
    // setter
    void setgalaxyType(String galaxyType){
        this.galaxyType=galaxyType;
    }
    void setestimatedStars(long estimatedStars){
        this.estimatedStars=estimatedStars;
    }

    // toString
    @Override
    public String toString(){
        return super.toString() + String.format("Galaxy type: %s\nEstimated stars: %d",this.galaxyType,this.estimatedStars);
        
    }
    
}
