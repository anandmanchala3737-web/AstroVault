package data;
import model.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class SpaceDatebase {
    
private final Map<String, CelestialObject> registry;

public SpaceDatebase(){
    this.registry=new HashMap<>();
    seedDatabase();
}

private void seedDatabase(){
// --- PLANETS ---
        addObject(new Planet(
            "Planet","Earth", 5.972e24, 6371.0, 9.81, 
            "The third planet from the Sun and the only astronomical object known to harbor life.",
            1, false, 1.0
        ));

        addObject(new Planet(
            "Planet","Mars", 6.39e23, 3389.5, 3.71, 
            "The fourth planet from the Sun, known as the Red Planet due to iron oxide on its surface.",
            2, false, 1.52
        ));

        addObject(new Planet(
            "Planet","Mercury", 3.301e23, 2439.7, 3.70, 
           "The smallest planet in the Solar System and the closest to the Sun.",
           0, false, 0.39
        ));

        addObject(new Planet(
          "Planet","Venus", 4.867e24, 6051.8, 8.87, 
          "The second planet from the Sun, possessing a thick, toxic atmosphere that traps heat.",
        0, false, 0.72
       ));

       addObject(new Planet(
         "Planet","Uranus", 8.681e25, 25362.0, 8.69, 
         "An ice giant planet featuring a distinct blue-green color and a severely tilted axis.",
         28, true, 19.22
     ));

       addObject(new Planet(
         "Planet","Neptune", 1.024e26, 24622.0, 11.15, 
        "The eighth and farthest known planet from the Sun, famous for its intense supersonic winds.",
        16, true, 30.05
     ));

       addObject(new Planet(
          "Planet","Pluto", 1.303e22, 1188.3, 0.62, 
          "A dwarf planet in the Kuiper belt, primarily composed of ice and rock.",
          5, false, 39.48
     ));

        addObject(new Planet(
            "Planet","Jupiter", 1.898e27, 69911.0, 24.79, 
            "The largest planet in the Solar System, a gas giant with a Great Red Spot.",
            95, true, 5.20
        ));

        addObject(new Planet(
            "Planet","Saturn", 5.683e26, 58232.0, 10.44, 
            "The second-largest planet in the Solar System, famous for its extensive ring system.",
            146, true, 9.58
        ));

        // --- STARS ---
        addObject(new Star(
            "Star","Sun", 1.989e30, 696340.0, 274.0, 
            "The yellow dwarf star at the center of our Solar System.",
            "G2V", 1.0
        ));

        addObject(new Star(
            "Star","Sirius", 4.178e30, 1183100.0, 200.0, 
            "The brightest star in the night sky, located in the constellation Canis Major.",
            "A1V", 25.4
        ));

        // --- MOONS ---
        addObject(new Moon(
            "Moon","Moon", 7.342e22, 1737.4, 1.62, 
            "Earth's only natural satellite.",
            "Earth"
        ));

        addObject(new Moon(
            "Moon","Europa", 4.80e22, 1560.8, 1.315, 
            "Jupiter's moon with a smooth ice shell and evidence of a subsurface ocean.",
            "Jupiter"
        ));

        // --- GALAXIES ---
        addObject(new Galaxy(
            "Galaxie","Milky Way", 1.5e12, 52850.0, 0.0, 
            "The barred spiral galaxy containing our Solar System.",
            "Barred Spiral", 100000000000L
        ));

        addObject(new Galaxy(
            "Galaxie","Andromeda", 1.23e12, 110000.0, 0.0, 
            "The nearest major galaxy to the Milky Way, expected to collide with it in ~4.5 billion years.",
            "Spiral", 1000000000000L
        ));

        // --- BLACK HOLES ---
        addObject(new BlackHole(
            "Black Hole","Sagittarius A*", 8.258e36, 12000000.0, 0.0, 
            "The supermassive black hole located at the Galactic Center of the Milky Way.",
            12000000.0
        ));
}
public void addObject(CelestialObject object){
    if(object != null && object.getName() != null){
    registry.put(object.getName().toLowerCase().trim(),object);
    }
}
public CelestialObject getObject(String name){
    if(name==null)return null;
    return registry.get(name.toLowerCase().trim());
}
public Collection<CelestialObject> getAllObjects() {
        return registry.values();
    }


}
