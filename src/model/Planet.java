package model;

public class Planet extends CelestialObject{

private int numberOfmoons;
private boolean hasRings;
private double   distanceFromSun;

    public Planet(String Type,String name, double mass, double radius,double surfaceGravity, String description,int numberOfmoons, boolean hasRings, double  distanceFromSun) {
        super(Type,name,mass,radius,surfaceGravity,description);
        this.numberOfmoons=numberOfmoons;
        this.hasRings=hasRings;
        this.distanceFromSun=distanceFromSun;
    }

// GETTER AND SETTER
// getter
int getnumberOfmoons(){
    return this.numberOfmoons;
}
boolean gethasRings(){
    return this.hasRings;
}
double getdistanceFromSun(){
    return this.distanceFromSun;
}
// setter
void setnumberOfmoons(int numberOfmoons){
    this.numberOfmoons=numberOfmoons;
}
void sethasRings(boolean hasRings){
    this.hasRings=hasRings;
}
void setdistanceFromSun(double distanceFromSun){
    this.distanceFromSun=distanceFromSun;
}
// toString
@Override
public String toString(){
    // return super.toString() +"\n"+ this.numberOfmoons +"\n"+ this.hasRings +"\n"+ this.distanceFromSun +"\n";
    return super.toString() + String.format("Number of Moons: %d\nHas Rings: %s\nDistance from sun: %.2f(AU)",this.numberOfmoons,(this.hasRings ? "yes":"No"),this.distanceFromSun);
}

}
