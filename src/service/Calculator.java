package service;

import model.CelestialObject;

public class Calculator {
    

    // Universal Gravitational Constant (G) in m^3 / (kg * s^2)
    public static final double G = 6.67430e-11;

    // Speed of Light in vacuum (c) in m/s
    public static final double SPEED_OF_LIGHT = 299792458.0;

    // Stefan-Boltzmann Constant (sigma) in W / (m^2 * K^4)
    public static final double STEFAN_BOLTZMANN = 5.670374e-8;

    // Standard Earth Surface Gravity (g_0) in m/s^2
    public static final double EARTH_GRAVITY = 9.80665;

    // Astronomical Unit (1 AU) in meters
    public static final double AU_IN_METERS = 1.495978707e11;

    // Mass of the Sun (M_sun) in kilograms
    public static final double SUN_MASS = 1.9885e30;

    // Luminosity of the Sun (L_sun) in Watts
    public static final double SUN_LUMINOSITY = 3.828e26;

    // Conversion helper: Seconds in one Earth Day
    public static final double SECONDS_PER_DAY = 86400.0;
    
    // PI
    public static final double PI = Math.PI;


// SurfaceGravity
    public double SurfaceGravity(double mass, double radius){
        double surfaceGravity;
        surfaceGravity=(G*mass)/(radius*radius);  /*(G.M)/R*R */
        return surfaceGravity;
    }
    public double SurfaceGravity(CelestialObject obj){  /*for how to pass object see case 2 */
        double surfaceGravity;
        surfaceGravity=(G*obj.getMass())/(obj.getRadius()*obj.getRadius());  /*(G.M)/R*R */
        return surfaceGravity;
    }
// Orbital Period
    public double OrbitalPeriod(double semiMajorAxis, double mass){
        double time=0;
        time=(2*PI)*Math.sqrt(Math.pow(semiMajorAxis,3)/(G*mass)); /*T = 2pi*sqrt{{a^3}/{G * M}}*/
        return time;
    }

// Schwarzschild Radius
    public double SchwarzschildRadius(double mass){
        double radius;
        // formula R=(2.G.M)/c^2
        radius=(2*G*mass)/(Math.pow(SPEED_OF_LIGHT,2));
        return radius;
    }
    public double SchwarzschildRadius(CelestialObject obj){
        double radius;
        // formula R=(2.G.M)/c^2
        radius=(2*G*obj.getMass())/(Math.pow(SPEED_OF_LIGHT,2));
        return radius;
    }
// Weight in different planets
    public double DirectWeight(double G_planet,double W_earth){
        double weight;
        // weight = W_earth*(G_planet/G_earth)
        weight=W_earth*(G_planet/EARTH_GRAVITY);
        return weight;
    }
    public double DirectWeight(double W_earth,double mass, double radius){
        double G_planet;
        G_planet=SurfaceGravity(mass,radius);
        double weight;
        // weight = W_earth*(G_planet/G_earth)
        weight=W_earth*(G_planet/EARTH_GRAVITY);
        return weight;
    }
//Orbital Velocity 
    public double OrbitalVelocity(double mass, double radius){
       double Orbital_V;
       Orbital_V=Math.sqrt((G*mass)/radius);
       return Orbital_V;
    }
    public double OrbitalVelocity(CelestialObject obj){
       double Orbital_V;
       Orbital_V=Math.sqrt((G*obj.getMass())/obj.getRadius());
       return Orbital_V;
    }
}
