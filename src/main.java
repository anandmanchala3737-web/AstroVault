import model.*;
import java.util.Scanner;
import data.*;

public class Main {
    public static void main(String[] args) {
        SpaceDatabase db = new SpaceDatabase();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========== ASTROVAULT ==========");
            System.out.println("1. View All Celestial Objects");
            System.out.println("2. Search Object");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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

