import dataStructures.Iterator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final String HELP = "help\n";
    private static final String ADD = "addcity\n";
    private static final String REMOVE = "removecity\n";
    private static final String POPULATION = "population\n";
    private static final String LIST = "listcities\n";
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
    private static final String LIST_MSG = "%s - %d - %s\n";
    private static final String NOT_AVAILABLE = "No cities available.\n";



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        App app  = new AppClass();
        commandInterpreter(in, app);
    }

    private static void commandInterpreter(Scanner in, App app) {
        String command = in.nextLine().toLowerCase();
        while(!command.equals(QUIT)) {
            switch (command) {
                case HELP -> help();
                case ADD -> add(in, app);
                case REMOVE -> remove(in, app);
                case POPULATION -> population(in, app);
                case LIST -> list(in, app);
            }
            command = in.nextLine();
        }
        quit();
    }

    private static void help() {
        System.out.printf(HELP_MESSAGE);
    }

    private static void quit(){
        //va meter a mrd da serialização aqui
        System.out.printf(QUIT_MSG);
    }

    private static void add(Scanner in, App app) {
        String name  = in.nextLine();
        String country = in.nextLine();
        int population = in.nextInt();
        in.nextLine();
        try{
            app.addCity(name, country, population);
            System.out.printf(ADDED);
        }catch(Exception e){
            System.out.printf(ALREADY_EXISTS);
        }
    }

    private static void remove(Scanner in, App app) {
        String cityName = in.nextLine();
        String country = in.nextLine();
        try{
            app.removeCity(cityName, country);
            System.out.printf(REMOVED);
        }catch(Exception e){
            System.out.printf(NOT_FOUND);
        }
    }

    private static void population(Scanner in, App app) {
        String city = in.nextLine();
        String country = in.nextLine();
        try{
            System.out.printf(POPULATION_MSG, app.getPopulation(city, country));
        }catch(Exception e){
            System.out.printf(NOT_FOUND);
        }
    }

    private static void list(Scanner in,  App app) {
        try{
            Iterator<Country> itCountry = app.listCountries();
            while(itCountry.hasNext()) {
                Country country = itCountry.next();
                Iterator<City> itCity = country.listCities();
                while (itCity.hasNext()) {
                    City city = itCity.next();
                    System.out.printf(LIST_MSG, country.getName(), city.getPopulation(), city.getName());
                }
            }
        }catch(NoSuchElementException e){
            System.out.printf(NOT_AVAILABLE);
        }
    }

}