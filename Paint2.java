import java.util.Scanner;

// Program that determines how many gallons of paint are needed for a wall of user-inputted dimensions.

public class Paint2 {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        double cansNeeded = 0.0;

        // Good practice is to name final variables as uppercase words separated by underscores.
        final double SQUARE_FEET_PER_GALLONS = 350.0;

        // Prompt user to input wall's height.
        System.out.println("Enter wall height (feet): ");
        wallHeight = scnr.nextDouble();


        // Prompt user to input wall's width.
        System.out.println("Enter wall width (feet): ");
        wallWidth = scnr.nextDouble();

        // Calculate and output wall area.
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate and output the amount of paint in gallons needed to paint the wall.
        gallonsPaintNeeded = wallArea / SQUARE_FEET_PER_GALLONS;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

        // Use Math.ceil() to "return the smallest double value... greater than or equal to the argument" and output it.
        cansNeeded = Math.ceil(gallonsPaintNeeded);
        System.out.println("Cans needed: " + cansNeeded + " can(s)");
    }
}
