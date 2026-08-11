package model;

public class BlackHole extends CelestialObject{
private double eventHorizonRadius;
    public BlackHole(String Type,String name, double mass, double radius, double surfaceGravity, String description,double eventHorizonRadius){
        super(Type,name,mass,radius,surfaceGravity,description);
        this.eventHorizonRadius=eventHorizonRadius;
    }

    // GETTER AND SETTER
    // getter
    double geteventHorizonRadius(){
        return this.eventHorizonRadius;
    }
    // setter
    void seteventHorizonRadius(double eventHorizonRadius){
        this.eventHorizonRadius=eventHorizonRadius;
    }

    // toString
    @Override
    public String toString(){
        return super.toString() + String.format("EventHorizon Radius: %.2f(km)",this.eventHorizonRadius);
    }
}
