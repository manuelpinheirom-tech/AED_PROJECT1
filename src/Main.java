import java.util.Scanner;

public class Main {

    private static final String HELP = "help\n";
    private static final String ADD = "addCity\n";
    private static final String REMOVE = "removeCity\n";
    private static final String POPULATION = "population\n";
    private static final String LIST = "listCities\n";
    private static final String QUIT = "quit\n";
    private static final String QUIT_MSG = "City directory saved.\n" +
    "Goodbye.\n";
    private static final String HELP_MESSAGE = "addCity: Adds a new city to the directory.\n" +
            "removeCity: Removes an existing city from the directory.\n" +
            "population: Returns the number of inhabitants of a city.\n" +
            "listCities: Lists all cities currently stored in the directory.\n" +
            "help: Displays the list of available commands.\n" +
            "quit: Terminates the application.\n";
    private static final String ADDED = "City successfully added.\n";
    private static final String ALREADY_EXISTS = "City already exists.\n";
    private static final String REMOVED = "City successfully removed.\n";
    private static final String NOT_FOUND = "City not found.\n";
    private static final String POPULATION_MSG = "Population: %d\n";
    private static final String NOT_EXISTS = "City not found.\n";
    private static final String LIST_MSG = "%s - %d - %s\n";
    private static final String NOT_AVAILABLE = "No cities available.\n";



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        App app  = new AppClass();
        commandInterpreter(in, app);
    }

    private static void commandInterpreter(Scanner in, App app) {
        String command = in.nextLine();
        while(!command.equalsIgnoreCase(QUIT)) {
            switch (command) {
                case HELP -> help();
                case ADD -> add();
                case REMOVE -> remove();
                case POPULATION -> population();
                case LIST -> list();
            }
            command = in.nextLine();
        }
        System.out.printf(QUIT_MSG);
    }

    private static void help() {

    }

    private static void add() {

    }

    private static void remove() {

    }

    private static void population() {

    }

    private static void list() {

    }

}