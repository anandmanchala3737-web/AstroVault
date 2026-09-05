import data.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
import service.Calculator;
public class Main {
    public static void main(String[] args) {
        SpaceDatabase db = new SpaceDatabase();
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========== ASTROVAULT ==========");
            System.out.println("1. View All Celestial Objects");
            System.out.println("2. Search Object");
            System.out.println("4. calculator");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice=0;
            try{
            choice = scanner.nextInt();
            scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Invaild option choose 1-3:");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    int i=1;
                    for (CelestialObject obj : db.getAllObjects()) {
                        System.out.println("\n"+i+")"+obj.getName() + " ("+obj.getType()+")");
                        i++;
                    }
                    System.out.println("**This are the CelestialObject I have, Choose one**");
                    break;
                case 2:
                    System.out.print("Enter object name: ");
                    String name = scanner.nextLine();
                    CelestialObject target = db.getObject(name);
                    if (target != null) {
                        System.out.println(target);
                    } else {
                        System.out.println("Object not found!");
                    }
                    break;
                case 4:
                    System.out.println(cal.SurfaceGravity(5.972e24, 6371e3));
                    break;
                case 3:
                    running = false;
                    System.out.println("NOTE:Some feature are going to update soon until PLEASE wait\nExiting AstroVault...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
        scanner.close();
    }
}

