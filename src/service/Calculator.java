package service;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.CelestialObject;
import java.text.DecimalFormat;

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

    public boolean running = true;
    Scanner scanner = new Scanner(System.in);

    public void WhileLoop(){
        while (running){
            System.out.println("\n========== Calculator ========");
            System.out.println("1. Surface Gravity");
            System.out.println("2. Orbital Period");
            System.out.println("3. Schwarzschild Radius");
            System.out.println("4. Direct Weight");
            System.out.println("5. Orbital Velocity");
            System.out.println("6. Escape Velocity");
            System.out.println("7. Stellar Luminosity");
            System.out.println("8. Habitable Zone");
            System.out.println("9. Exit");

            int choice;
            try{
            System.out.print("Enter a choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Invaild option choose 1-8:");
                scanner.nextLine();
                continue;
            }
            switch(choice){
                case 1 ->{
                double mass = read(scanner,"Enter the masss(kg): ");
                double radius =  read(scanner,"Enter the radius(m): ");
                System.out.println("Surface Gravity: "+formatter(SurfaceGravity(mass,radius)));
                }
                case 2 ->{
                double semiMajorAxis =  read(scanner,"Enter the semi-major axis(m): ");
                double mass =  read(scanner,"Enter the mass(kg): ");
                System.out.println("Orbital Period: "+formatter(OrbitalPeriod(semiMajorAxis,mass)));
                }
                case 3 ->{
                double mass =  read(scanner,"Enter the mass(kg): ");
                System.out.println("Schwarzschild Radius: "+formatter(SchwarzschildRadius(mass)));
                }
                case 4 ->{
                double G_planet =  read(scanner,"Enter the Surface Grvity(m/s^2): ");
                double W_earth =  read(scanner,"Enter weight of the object in earth(kg): ");
                System.out.println("Weight in other planet:"+formatter(DirectWeight(G_planet,W_earth)));
                }
                case 5 ->{
                double mass =  read(scanner,"Enter the mass(kg): ");
                double radius =  read(scanner,"Enter the radius(m): ");
                System.out.println("Orbital Velocity: "+formatter(OrbitalVelocity(mass,radius)));
                }
                case 6 ->{
                double mass =  read(scanner,"Enter the mass(kg): ");
                double radius =  read(scanner,"Enter the radius(m): ");
                System.out.println("Escape velociy: "+formatter(Escapevelociy(mass,radius)));
                }
                case 7 ->{
                double radius =  read(scanner,"Enter the radius(m): ");
                double temp =  read(scanner,"Enter the temparature(K): ");
                System.out.println("Stellar Luminosity: "+formatter(StellarLuminosity(radius,temp)));
                }
                case 8 ->{
                double starLumi =  read(scanner,"Enter the stellar Luminosity(watts): ");
                System.out.println("Habitable Zone: "+formatter(HabitableZone(starLumi)));
                }
                case 9 ->
                running = false;
            }
            }
        }

        public String formatter(double value){
            BigDecimal bd = new BigDecimal(value);
            DecimalFormat formatter =new DecimalFormat("#,###");
            return formatter.format(bd);
        }
        private static double read(Scanner scanner, String prompt){
            while(true){
                System.out.print(prompt);
                try{
                   double value= scanner.nextDouble();
                   scanner.nextLine();
                   if(value <= 0){
                    System.out.println("Invalid input! Negative number or zero are not allowed");
                   }else{
                    return value;
                   }
                }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
                }
            }
        }


/**
 * Calculates the Surface Gravity of a celestial object.
 *
 * @param mass Mass of the object in kilograms.
 * @param radius Radius of the object in meters.
 * @return Surface Gravity in meters per second (m/s^2).
 */
    public double SurfaceGravity(double mass, double radius){
        double surfaceGravity;
        surfaceGravity=(G*mass)/(radius*radius);  //(G.M)/R*R 
        return surfaceGravity;
    }
    public double SurfaceGravity(CelestialObject obj){  /*for how to pass object see case 2 */
        double surfaceGravity;
        surfaceGravity=(G*obj.getMass())/(obj.getRadius()*obj.getRadius());  /*(G.M)/R*R */
        return surfaceGravity;
    }

    /**
 * Calculates the Orbital Period of a celestial object.
 *
 * @param semiMajorAxis of the object in meters.
 * @param mass mass of the object in kilograms.
 * @return Orbital Period in seconds.
 */
    public double OrbitalPeriod(double semiMajorAxis, double mass){
       double time=(2*PI)*Math.sqrt(Math.pow(semiMajorAxis,3)/(G*mass)); /*T = 2pi*sqrt{{a^3}/{G * M}}*/
        return time;
    }

    /**
 * Calculates the Schwarzschild Radius of a celestial object.
 *
 * @param mass mass of the object in kilograms.
 * @return Schwarzschild Radius in meters.
 */
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
    
    /**
 * Calculates the Direct Weight of a celestial object.
 *
 * @param G_planet surface gravity of the object in m/s^2.
 * @param W_earth weight of the object in earth is in kilograms.
 * @return Object weight in kilograms.
 */
    public double DirectWeight(double G_planet,double W_earth){
        // weight = W_earth*(G_planet/G_earth)
        double weight=W_earth*(G_planet/EARTH_GRAVITY);
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
    /**
 * Calculates the Orbital Velocity of a celestial object.
 *
 * @param mass mass of the object in kilograms.
 * @param radius radius of the object in meters.
 * @return Orbital Velocity in meters per seconds.
 */
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

    /**
 * Calculates the Escape Velocity of a celestial object.
 *
 * @param mass mass of the object in kilograms.
 * @param radius radius of the object in meters.
 * @return Escape Velocity in meters per seconds.
 */
    public double Escapevelociy(double mass, double radius){
        double esp=Math.sqrt((2*G*mass)/radius);
        return esp;
    }
    public double Escapevelociy(CelestialObject obj){
        double esp=Math.sqrt((2*G*obj.getMass())/obj.getRadius());
        return esp;
    }

    /**
 * Calculates the Stellar Luminosity of a celestial object.
 *
 * @param radius radius of the object in meters.
 * @param temp temparature of the object in Kelvin
 * @return Stellar Luminosity of the object in power/watts.
 */
    public double StellarLuminosity(double radius, double temp){
        double lumi=(4*PI)*(Math.pow(radius,2))*(STEFAN_BOLTZMANN*(Math.pow(temp,4)));
        return lumi/SUN_LUMINOSITY;
    }
    /**
 * Calculates the Habitable Zone of a celestial object.
 *
 * @param starLumi Stellar Luminosity of the object in power/watts.
 * @return Habitable Zone of the object in Astronomical Unit.
 */
    public double HabitableZone(double starLumi){   //watts
        double habiZone=Math.sqrt(starLumi/SUN_LUMINOSITY);
        return habiZone;
    }

}
