package model;

public class CelestialObject {
private String Type;
private String name;
private double mass;
private double radius;
private double surfaceGravity ;
private String description;

CelestialObject(String Type,String name, double mass, double radius, double surfaceGravity, String description){
    
    this.name=name;
    this.mass=mass;
    this.radius=radius;
    this.Type=Type;
    this.surfaceGravity=surfaceGravity;
    this.description=description;

}

// GETTER AND SETTER
// getter
public String getName(){
    return this.name;
}
public double getMass(){
    return this.mass;
}
public double getRadius(){
    return this.radius;
}
public String getType(){
    return this.Type;
}
public double getsurfaceGravity(){
    return this.surfaceGravity;
}
public String getDescription(){
    return this.description;
}

// setter
public void setName(String name){
    this.name=name;
}
public void setMass(double mass){
    this.mass=mass;
}
public void setRadius(double radius){
    this.radius=radius;
}
public void setType(String Type){
    this.Type=Type;
}
public void setsurfaceGravity(double surfaceGravity){
    this.surfaceGravity=surfaceGravity;
}
public void setDescription(String description){
    this.description=description;
}

// toString
@Override
public String toString(){
    // return this.name +"\n"+ this.mass +"\n"+ this.radius +"\n"+ this.surfaceGravity+"\n"+ this.description;
    return String.format("\nType: %s\nName: %s\nMass: %.2f(Kg)\nRadius: %.2f(Km)\nSurface Gravity: %.2f(ms\u00B2)\nDescription: %s\n",this.Type,this.name,this.mass,this.radius,this.surfaceGravity,this.description);
}

}
