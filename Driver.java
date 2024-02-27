import java.util.ArrayList;
import java.util.Scanner;

// Program that stores and allows the user to interact with information about rescue animals at Grazioso Salvare.

public class Driver {  // Driver holds main().
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();  // Where dogs' information is stored.
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();  // Where monkeys' information is stored.

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);  // scnr is initialized for reading in input.
        char input = '0';  // input is initialized for use in the while loop.

        // The two 'initialize' methods populate the dog and monkey ArrayLists for testing.
        initializeDogList();
        initializeMonkeyList();

        while (input != 'q') {
            displayMenu();  // Continually re-displays menu for ease-of-use.
            input = scnr.nextLine().charAt(0);  // Continually gets input from user.

            switch (input) {  // Switch statement is used to intuitively mimic the menu structure.
                case '1':
                    intakeNewDog(scnr);
                    break;
                case '2':
                    intakeNewMonkey(scnr);
                    break;
                case '3':
                    reserveAnimal(scnr);
                    break;
                case '4':
                    printAnimals(4);
                    break;
                case '5':
                    printAnimals(5);
                    break;
                case '6':
                    printAnimals(6);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    }

    public static void displayMenu() {  // Prints menu options for user to choose from.
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("-----------------------------------------------------------");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are in-service and not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection: ");
    }

    public static void initializeDogList() {  // Adds dogs to a list for testing.
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                           false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I",
                           false, "United Kingdom");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "5.6", "12-12-2019", "Canada", "in-service",
                           false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {  // Adds monkeys to a list for testing.
        Monkey monkey1 = new Monkey("Franz", "Capuchin", "1.1", "23", "5", "male", "2", "2.6", "12-02-2017",
                                    "Canada", "Phase IV", false, "United States");
        Monkey monkey2 = new Monkey("Lydia", "Squirrel monkey", "5.9", "22", "15", "female", "3", "5.6", "04-12-2020",
                                    "United States", "Phase III", false, "United States");
        Monkey monkey3 = new Monkey("Dottie", "Marmoset", "10", "5", "3", "female", "1", "11.2", "07-30-2018",
                                    "United States", "in-service", false, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    public static void intakeNewDog(Scanner scnr) {  // Allows the user to enter a new dog into dogList.
        System.out.println("1) What is the dog's name?");
        String name = scnr.nextLine();

        for (Dog dog : dogList) {  // Input validation for name using enhanced for loop.
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system.\n");
                return; // Returns to menu.
            }
        }
        System.out.println("2) What is the dog's breed?");
        String breed = scnr.nextLine();

        System.out.println("3) What is the dog's gender?");
        String gender = scnr.nextLine();

        System.out.println("4) What is the dog's age?");
        String age = scnr.nextLine();

        System.out.println("5) What is the dog's weight?");
        String weight = scnr.nextLine();

        System.out.println("6) What is the dog's acquisition date?");
        String acquisitionDate = scnr.nextLine();

        System.out.println("7) What is the dog's acquisition country?");
        String acquisitionCountry = scnr.nextLine();

        System.out.println("8) What is the dog's training status?");
        System.out.println("(intake, Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, or farm)");
        String trainingStatus = scnr.nextLine();

        String reservedStatus = "null";
        boolean reserved = false;
        do {  // Input validation for reservation status, since a boolean strictly needs 'true' or 'false'.
            System.out.println("9) Is the dog reserved? Enter 'true' or 'false'.");
            reservedStatus = scnr.nextLine();

            if (reservedStatus.equalsIgnoreCase("true")) {
                reserved = true;
                break;
            }
            else if (reservedStatus.equalsIgnoreCase("false")) {  // Nothing to change -- reserved is false by default.
                break;
            }
        } while (!reservedStatus.equalsIgnoreCase("true") && !reservedStatus.equalsIgnoreCase("false"));

        System.out.println("10) What is the dog's in-service country?");
        String inServiceCountry = scnr.nextLine();

        // The data taken from user input gets set to a new instance of Dog.
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);

        // The newly instantiated Dog is added to its appropriate ArrayList.
        dogList.add(newDog);
    }

    public static void intakeNewMonkey(Scanner scnr) {  // Allows the user to input a new monkey into monkeyList.
        System.out.println("1) What is the monkey's name?");
        String name = scnr.nextLine();

        for (Monkey monkey : monkeyList) {  // Input validation for name using enhanced for loop.
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey is already in our system.\n");
                return; // Returns to menu.
            }
        }

        System.out.println("2) What is the monkey's species?");
        String species = scnr.nextLine();

        // Input validation for species using while loop.
        while (!(species.equalsIgnoreCase("Capuchin")) && !(species.equalsIgnoreCase("Guenon")) &&
                !(species.equalsIgnoreCase("Macaque")) && !(species.equalsIgnoreCase("Marmoset")) &&
                !(species.equalsIgnoreCase("Squirrel monkey")) && !(species.equalsIgnoreCase("Tamarin"))) {
            System.out.println("That is an invalid monkey species. Please select from: Capuchin, Guenon, Macaque," +
                    " Marmoset, Squirrel monkey, or Tamarin.");
            species = scnr.nextLine();
        }

        System.out.println("3) What is the monkey's tail length?");
        String tailLength = scnr.nextLine();

        System.out.println("4) What is the monkey's height?");
        String height = scnr.nextLine();

        System.out.println("5) What is the monkey's body length?");
        String bodyLength = scnr.nextLine();

        System.out.println("6) What is the monkey's gender?");
        String gender = scnr.nextLine();

        System.out.println("7) What is the monkey's age?");
        String age = scnr.nextLine();

        System.out.println("8) What is the monkey's weight?");
        String weight = scnr.nextLine();

        System.out.println("9) What is the monkey's acquisition date?");
        String acquisitionDate = scnr.nextLine();

        System.out.println("10) What is the monkey's acquisition country?");
        String acquisitionCountry = scnr.nextLine();

        System.out.println("11) What is the monkey's training status?");
        System.out.println("(intake, Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, or farm)");
        String trainingStatus = scnr.nextLine();

        String reservedStatus;
        boolean reserved = false;
        do {  // Input validation for reservation status, since a boolean strictly needs 'true' or 'false'.
            System.out.println("12) Is the monkey reserved? Enter 'true' or 'false'.");
            reservedStatus = scnr.nextLine();

            if (reservedStatus.equalsIgnoreCase("true")) {
                reserved = true;
                break;
            }
            else if (reservedStatus.equalsIgnoreCase("false")) {  // Nothing to change -- reserved is false by default.
                break;
            }
        } while (!reservedStatus.equalsIgnoreCase("true") && !reservedStatus.equalsIgnoreCase("false"));

        System.out.println("13) What is the monkey's in-service country?");
        String inServiceCountry = scnr.nextLine();

        // The data taken from user input gets set to a new instance of Monkey.
        Monkey newMonkey = new Monkey(name, species, tailLength, height, bodyLength, gender, age, weight,
                acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        // The newly instantiated Monkey is added to its appropriate ArrayList.
        monkeyList.add(newMonkey);
    }

    public static void reserveAnimal(Scanner scnr) {  // Allows user to reserve an available rescue animal.
        String type;  // "type" variable is used throughout the method.

        do {  // do-while loop lets user enter input before validating said input.
            System.out.println("Enter the animal's type (dog or monkey): ");
            type = scnr.nextLine().toLowerCase();  // toLowerCase() helps validate input.
        } while (!type.equals("dog") && !type.equals("monkey"));  // type must equal dog or monkey.

        System.out.println("Enter the animal's country: ");
        String country = scnr.nextLine().toLowerCase();

        boolean reservedSuccess = false;  // Used to output results of a failed reservation (below).
        if (type.equals("dog")) {
            for (Dog dog : dogList) {  // Enhanced for loop iterates through dogList ArrayList.
                // dog must be unreserved, in the desired country, and in-service.
                if (dog.getInServiceLocation().equalsIgnoreCase(country) && !dog.getReserved() &&
                    dog.getTrainingStatus().equalsIgnoreCase("in-service")) {
                    System.out.println("\n*** " + dog.getName() + " is now reserved. ***");
                    dog.setReserved(true);    // Reservation status changed to true.
                    reservedSuccess = true;
                    return;  // Returns to menu.
                }
            }
            if (!reservedSuccess) {  // Outputs the failed reservation status to user.
                System.out.println("\nThere are no dogs available in that country.");
                System.out.println("Please view the list of all dogs to see availability.");
            }
        }

        // Same process as above for dogList-- this time, for monkeyList.
        if (type.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(country) && !monkey.getReserved() &&
                    monkey.getTrainingStatus().equalsIgnoreCase("in-service")) {
                    System.out.println("\n*** " + monkey.getName() + " is now reserved. ***");
                    monkey.setReserved(true);
                    return;
                }
            }
            if (!reservedSuccess) {
                System.out.println("\nThere are no monkeys available in that country.");
                System.out.println("Please view the list of all monkeys to see availability.");
            }
        }
    }

    public static void printAnimals(int menuChoice) {  // Allows user to view certain animals, depending on input.
        if (menuChoice == 4) {  // Prints all dogs and their attributes.
            System.out.println("\n DOGS");
            System.out.println("------");
            for (Dog dog : dogList) {  // Enhanced for loop iterates through every dog in dogList.
                System.out.println("Name: " + dog.getName() +
                                   " | Breed: " + dog.getBreed() +
                                   " | Gender: " + dog.getGender() +
                                   " | Age: " + dog.getAge() +
                                   " | Weight: " + dog.getWeight() + "\n" +
                                   "Acquisition date: " + dog.getAcquisitionDate() +
                                   " | Acquisition country: " + dog.getAcquisitionLocation() +
                                   " | In-service country: " + dog.getInServiceLocation() + "\n" +
                                   "Training Status: " + dog.getTrainingStatus() +
                                   " | Reservation status: " + dog.getReserved());

                System.out.println();
            }
        }

        else if (menuChoice == 5) {  // Prints all monkeys and their attributes.
            System.out.println("\n MONKEYS");
            System.out.println("---------");
            for (Monkey monkey : monkeyList) {  // Enhanced for loop iterates through every monkey in monkeyList.
                System.out.println("Name: " + monkey.getName() +
                                   " | Species: " + monkey.getSpecies() +
                                   " | Gender: " + monkey.getGender() +
                                   " | Age: " + monkey.getAge() +
                                   " | Height: " + monkey.getHeight() +
                                   " | Weight: " + monkey.getWeight() +
                                   " | Tail length: " + monkey.getTailLength() +
                                   " | Body length: " + monkey.getBodyLength() + "\n" +
                                   "Acquisition date: " + monkey.getAcquisitionDate() +
                                   " | Acquisition country: " + monkey.getAcquisitionLocation() +
                                   " | In-service country: " + monkey.getInServiceLocation() + "\n" +
                                   "Training Status: " + monkey.getTrainingStatus() +
                                   " | Reservation status: " + monkey.getReserved());
                System.out.println();
            }
        }

        else if (menuChoice == 6) {  // Prints only available and fully-trained animals of both types.
            System.out.println("ALL AVAILABLE & FULLY-TRAINED ANIMALS\n");

            System.out.println(" DOG(S)");
            System.out.println("--------");
            for (Dog dog : dogList) {
                // dog must be in-service and unreserved.
                if (dog.getTrainingStatus().equalsIgnoreCase("in-service") && !dog.getReserved()) {
                    System.out.println("Name: " + dog.getName() +
                                       " | Breed: " + dog.getBreed() +
                                       " | Gender: " + dog.getGender() +
                                       " | Age: " + dog.getAge() +
                                       " | Weight: " + dog.getWeight() + "\n" +
                                       "Acquisition date: " + dog.getAcquisitionDate() +
                                       " | Acquisition country: " + dog.getAcquisitionLocation() +
                                       " | In-service country: " + dog.getInServiceLocation() + "\n" +
                                       "Training Status: " + dog.getTrainingStatus() +
                                       " | Reservation status: " + dog.getReserved());
                    System.out.println();
                }
            }

            System.out.println("\n MONKEY(S)");
            System.out.println("-----------");
            for (Monkey monkey : monkeyList) {
                // monkey must be in-service and unreserved.
                if (monkey.getTrainingStatus().equalsIgnoreCase("in-service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName() +
                                       " | Species: " + monkey.getSpecies() +
                                       " | Gender: " + monkey.getGender() +
                                       " | Age: " + monkey.getAge() +
                                       " | Height: " + monkey.getHeight() +
                                       " | Weight: " + monkey.getWeight() +
                                       " | Tail length: " + monkey.getTailLength() +
                                       " | Body length: " + monkey.getBodyLength() + "\n" +
                                       "Acquisition date: " + monkey.getAcquisitionDate() +
                                       " | Acquisition country: " + monkey.getAcquisitionLocation() +
                                       " | In-service country: " + monkey.getInServiceLocation() + "\n" +
                                       "Training Status: " + monkey.getTrainingStatus() +
                                       " | Reservation status: " + monkey.getReserved());
                    System.out.println();
                }
            }
        }
    }
}
