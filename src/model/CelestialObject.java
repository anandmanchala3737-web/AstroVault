package Model;

public class CelestialObject {
private String name;
private double mass;
private double radius;
private double surfaceGravity ;
private String description;

CelestialObject(String name, double mass, double radius, double surfaceGravity, String description){

    this.name=name;
    this.mass=mass;
    this.radius=radius;
    this.surfaceGravity=surfaceGravity;
    this.description=description;

}

// GETTER AND SETTER
// getter
String getName(){
    return this.name;
}
double getMass(){
    return this.mass;
}
double getRadius(){
    return this.radius;
}
double getsurfaceGravity(){
    return this.surfaceGravity;
}
String getDescription(){
    return this.description;
}

// setter
void setName(String name){
    this.name=name;
}
void setMass(double mass){
    this.mass=mass;
}
void setRadius(double radius){
    this.radius=radius;
}
void setsurfaceGravity(double surfaceGravity){
    this.surfaceGravity=surfaceGravity;
}
void setDescription(String description){
    this.description=description;
}

// toString
@Override
public String toString(){
    // return this.name +"\n"+ this.mass +"\n"+ this.radius +"\n"+ this.surfaceGravity+"\n"+ this.description;
    return String.format("Name: %s\nMass: %.2f\nRadius: %.2f\nSurface Gravity: %.2f\nDescription: %s\n",this.name,this.mass,this.radius,this.surfaceGravity,this.description);
}

}
