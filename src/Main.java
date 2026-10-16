import CityProject.*;
import dataStructures.Iterator;

import java.io.*;
import dataStructures.exceptions.NoSuchElementException;
import dataStructures.exceptions.ElementAlreadyExistsException;
import java.util.Scanner;

/**
 * Main class that manages user interaction and the application's lifecycle.
 * Space Complexity: O(1) auxiliary space (the memory grows based on the data
 * stored in the CityProject.App instance, but the Main class itself only manages references).
 * Authors:
 * - Joana Brito, 74082
 * - Manuel Mendes, 74538
 */
public class Main {

    private static final String SERIAL_FILE = "1_.ser";

    /**
     * Entry point of the application.
     * Time Complexity:
     * - Best case: O(1) (if the file doesn't exist and the first command is QUIT).
     * - Worst case: O(C * T) where C is the number of commands and T is the complexity of the heaviest command.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        App app  = loadApp();
        commandInterpreter(in, app);
        in.close();
    }

    /**
     * Reads and interprets the commands entered by the user.
     * Time Complexity:
     * - Best case: O(1) (immediate QUIT command).
     * - Worst case: O(C * T) where C is the number of commands and T is the maximum complexity of the called operation.
     * @param in Scanner to read user input.
     * @param app Application instance.
     */
    private static void commandInterpreter(Scanner in, App app) {
        Command command = Command.fromString(in.nextLine());
        while(command != Command.QUIT) {
            switch (command) {
                case HELP -> help();
                case ADD -> add(in, app);
                case REMOVE -> remove(in, app);
                case POPULATION -> population(in, app);
                case LIST -> list (app);
            }
            command = Command.fromString(in.nextLine());
        }
        quit(app);
    }

    /**
     * Prints the help message displaying available commands.
     * Time Complexity:
     * - Best and Worst case: O(1).
     */
    private static void help() {
        System.out.print(Message.HELP);
    }

    /**
     * Terminates the application and saves its state.
     * Time Complexity:
     * - Strictly depends on the saveApp method.
     * @param app Application instance to save.
     */
    private static void quit(App app){
        saveApp(app);
    }

    /**
     * Serializes and saves the current state of the application to a file.
     * Time Complexity:
     * - Best case: O(1) (if the application is empty).
     * - Worst case: O(N) where N is the total number of objects (cities, countries, tree/list nodes) to serialize.
     * @param app Application instance to save.
     */
    private static void saveApp(App app) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(app);
            System.out.print(Message.QUIT);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the application state from a serialized file.
     * Time Complexity:
     * - Best case: O(1) (file does not exist or is empty).
     * - Worst case: O(N) where N is the total number of objects instantiated from the file.
     * @return the loaded application instance or a new one if an error occurs/file doesn't exist.
     */
    private static AppClass loadApp() {
        File file = new File(SERIAL_FILE);
        if (!file.exists()) {
            System.out.print(Message.NO_CITIES);
            return new AppClass();
        }
        try (ObjectInputStream doc = new ObjectInputStream(new FileInputStream(file))) {
            AppClass app = (AppClass) doc.readObject();
            System.out.print(Message.CITIES_RESTORED);
            return app;
        } catch (Exception e) {
            System.out.print(Message.NO_CITIES);
            return new AppClass();
        }
    }

    /**
     * Adds a new city to the application.
     * Time Complexity:
     * - Dictated by the app.addCity() method.
     * (Generally O(log N) for search trees or O(1)/O(N) depending on the backend structure).
     * @param in Scanner for reading data.
     * @param app Application instance.
     */
    private static void add(Scanner in, App app) {
        String name  = in.nextLine();
        String country = in.nextLine();
        int population = in.nextInt();
        in.nextLine();
        try{
            app.addCity(name, country, population);
            System.out.print(Message.ADDED);
        }catch(ElementAlreadyExistsException e){
            System.out.print(Message.ALREADY_EXISTS);
        }
    }

    /**
     * Removes a city from the application.
     * Time Complexity:
     * - Dictated by the app.removeCity() method.
     * (Generally O(log N) or O(N) depending on the data structure used).
     * @param in Scanner for reading data.
     * @param app Application instance.
     */
    private static void remove(Scanner in, App app) {
        String cityName = in.nextLine();
        String country = in.nextLine();
        try{
            app.removeCity(cityName, country);
            System.out.print(Message.REMOVED);
        }catch(NoSuchElementException e){
            System.out.print(Message.NOT_FOUND);
        }
    }

    /**
     * Queries and prints the population of a specific city.
     * Time Complexity:
     * - Dictated by the app.getPopulation() method.
     * (Generally O(log N) for searching).
     * @param in Scanner for reading data.
     * @param app Application instance.
     */
    private static void population(Scanner in, App app) {
        String city = in.nextLine();
        String country = in.nextLine();
        try{
            System.out.printf(Message.POPULATION.toString(), app.getPopulation(city, country));
        }catch(NoSuchElementException e){
            System.out.print(Message.NOT_FOUND);
        }
    }

    /**
     * Lists all countries and their respective cities in the application.
     * Time Complexity:
     * - Best case: O(1) (if no countries/cities exist, throws exception).
     * - Worst case: O(P + C), where P is the number of countries and C is the total number of registered cities.
     * @param app Application instance.
     */
    private static void list(App app) {
        try{
            Iterator<? extends CountryInfo> itCountry = app.listCountries();
            while(itCountry.hasNext()) {
                CountryInfo country = itCountry.next();
                Iterator<City> itCity = country.listCities();
                while (itCity.hasNext()) {
                    City city = itCity.next();
                    System.out.printf(Message.LIST.toString(), country.getName(), city.population(), city.name());
                }
            }
        }catch(NoSuchElementException e){
            System.out.print(Message.NOT_AVAILABLE);
        }
    }

}