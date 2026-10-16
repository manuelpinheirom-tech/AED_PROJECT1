package CityProject;

import dataStructures.Iterator;
import dataStructures.exceptions.ElementAlreadyExistsException;
import dataStructures.exceptions.NoSuchElementException;

public interface App {
    /**
     * Adds a new city to the specified country.
     * @param city the name of the city.
     * @param country the name of the country.
     * @param population the population of the city.
     * @throws ElementAlreadyExistsException if the city already exists in the given country.
     */
    void addCity(String city,  String country, int population) throws ElementAlreadyExistsException;
    /**
     * Removes a city from the specified country. If the country becomes empty, it is also removed.
     * @param city the name of the city to remove.
     * @param country the name of the country.
     * @throws NoSuchElementException if the country or city does not exist.
     */
    void removeCity(String city, String country) throws NoSuchElementException;
    /**
     * Retrieves the population of a specific city.
     * @param city the name of the city.
     * @param country the name of the country.
     * @return the population of the city.
     * @throws NoSuchElementException if the country or city is not found.
     */
    int getPopulation(String city, String country) throws NoSuchElementException ;
    /**
     * Returns an iterator over the countries stored in the application.
     * @return an Iterator over the stored CityProject.Country objects.
     * @throws NoSuchElementException if there are no countries available.
     */
    Iterator<? extends CountryInfo> listCountries()  throws NoSuchElementException ;
}
