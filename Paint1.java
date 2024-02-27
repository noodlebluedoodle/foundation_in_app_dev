import java.util.Scanner;
import java.util.InputMismatchException;

// Program that determines how many gallons of paint are needed for a wall, given its height and width.

public class Paint1 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        
        final double SQUARE_FEET_PER_GALLONS = 350.0;  // This amount is static.

        // do-while loop validates input to be greater than 0, while the exception catches any non-numerical input.
        do {
            // Prompt user to input wall's height.
            System.out.println("Enter wall height (feet): ");

            try {
                wallHeight = scnr.nextDouble();
                if (wallHeight == 0) {  // Executes only upon the entry of 0.
                    System.out.println("Please enter a number greater than 0.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a number such as 25.3 or 11.");
                scnr.nextLine();  // "Throws away" incorrect answer.
            }
        } while (wallHeight <= 0.0);  // Height cannot be less than or equal to 0.

        // do-while loop validates input to be greater than 0, while the exception catches any non-numerical input.
        do {
            // Prompt user to input wall's width.
            System.out.println("Enter wall width (feet): ");
            
            try {
                wallWidth = scnr.nextDouble();
                if (wallWidth == 0) {  // Executes only upon the entry of 0.
                    System.out.println("Please enter a number greater than 0.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a number such as 25.3 or 11.");
                scnr.nextLine();  // "Throws away" incorrect answer.
            }
        } while (wallWidth <= 0.0);  // Width cannot be less than or equal to 0.

        // Calculate and output wall area.
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate and output the amount of paint (in gallons) needed to paint the wall.
        gallonsPaintNeeded = wallArea/SQUARE_FEET_PER_GALLONS;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
    }
}
