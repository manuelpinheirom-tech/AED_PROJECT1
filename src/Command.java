/**
 * Enum representing the available commands in the application.
 * Space Complexity: O(1) auxiliary space, as it contains a strictly fixed 
 * number of constants and does not scale with the input size.
 */
public enum Command {
    HELP("help"),
    ADD("addcity"),
    REMOVE("removecity"),
    POPULATION("population"),
    LIST("listcities"),
    QUIT("quit"),
    UNKNOWN("");

    private final String keyword;

    /**
     * Constructor for the Command enum.
     * Time Complexity: 
     * - Best and Worst case: O(1).
     * @param keyword the string representation of the command.
     */
    Command(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Parses a string and returns the corresponding Command enum.
     * Time Complexity:
     * - Best case: O(1) (if the text is null or matches the first constant).
     * - Worst case: O(n) (the number of commands is fixed, so iterating through values()
     *   and comparing strings takes bounded, constant time).
     * @param text the input string to parse.
     * @return the corresponding Command, or UNKNOWN if no match is found.
     */
    public static Command fromString(String text) {
        if (text == null) return UNKNOWN;
        String trimmed = text.trim().toLowerCase();
        for (Command cmd : values()) {
            if (cmd.keyword.equalsIgnoreCase(trimmed)) {
                return cmd;
            }
        }
        return UNKNOWN;
    }
}