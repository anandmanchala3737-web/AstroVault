package model;
public class Star extends CelestialObject{
private String spectralType;
private double luminosity;

 public Star(String Type,String name, double mass, double radius, double surfaceGravity, String description,String spectraType, double luminosity) {
        super(Type,name,mass,radius,surfaceGravity,description);
        this.spectralType=spectraType;
        this.luminosity=luminosity;
 }

//  GETTER AND SETTER
// getter
String getspectraType(){
    return this.spectralType;
}
double getluminosity(){
    return this.luminosity;
}
// setter
void setspectralType(String spectralType){
    this.spectralType=spectralType;
}
void setluminosity(double luminosity){
    this.luminosity=luminosity;
}
// toString
@Override
public String toString(){
    // return super.toString() +"\n"+ this.spectralType +"\n"+ this.luminosity;
    return super.toString() + String.format("Type of the spectral: %s\nLuminosity: %.2f(L\u2609)",this.spectralType,this.luminosity);
}
}
