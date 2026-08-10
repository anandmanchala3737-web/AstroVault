package Model;
public class Moon extends CelestialObject{
    private String parentPlanet;

    public Moon(String name, double mass, double radius, double surfaceGravity, String description,String parentPlanet){
        super(name,mass,radius,surfaceGravity,description);
        this.parentPlanet=parentPlanet;
    }

// GETTER AND SETTER
// getter
String getparentPlanet(){
    return this.parentPlanet;
}
// setter
void setparentPlanet(String parentPlanet){
    this.parentPlanet=parentPlanet;
}

// toString
@Override
public String toString(){
    return super.toString() + String.format("Parent planet: %s\n",this.parentPlanet);
}
}
