package CityProject;

/**
 * Enum representing the various output messages of the application.
 * Space Complexity: O(1) auxiliary space, as it stores a fixed number 
 * of predefined string constants that do not scale with input size.
 */
public enum Message {
    QUIT("CityProject.City directory saved.\nGoodbye.\n"),
    HELP("addCity: Adds a new city to the directory.\n" +
            "removeCity: Removes an existing city from the directory.\n" +
            "population: Returns the number of inhabitants of a city.\n" +
            "listCities: Lists all cities currently stored in the directory.\n" +
            "help: Displays the list of available commands.\n" +
            "quit: Terminates the application.\n"),
    ADDED("CityProject.City successfully added.\n"),
    ALREADY_EXISTS("CityProject.City already exists.\n"),
    REMOVED("CityProject.City successfully removed.\n"),
    NOT_FOUND("CityProject.City not found.\n"),
    POPULATION("Population: %d\n"),
    LIST("%s - %d - %s\n"),
    NOT_AVAILABLE("No cities available.\n"),
    CITIES_RESTORED("CityProject.City directory restored successfully.\n"),
    NO_CITIES("CityProject.City directory not found.\nCreating an empty city directory.\n");

    private final String text;

    /**
     * Constructor for the CityProject.Message enum.
     * Time Complexity: 
     * - Best and Worst case: O(1).
     * @param text the string representation of the message.
     */
    Message(String text) {
        this.text = text;
    }

    /**
     * Returns the string representation of the message.
     * Time Complexity: 
     * - Best and Worst case: O(1).
     * @return the message text.
     */
    @Override
    public String toString() {
        return text;
    }
}