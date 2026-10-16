package CityProject;

import dataStructures.Iterator;
import dataStructures.exceptions.NoSuchElementException;

public interface CountryInfo  {
    /**
     * Retrieves the name of the country.*
     * @return the name of the country.
     */
    String getName();
    /**
     * Checks if a specific city exists in this country.*
     * @param name the name of the city to check.
     * @return true if the city exists, false otherwise.
     */
    boolean hasCity(String name);
    /**
     * Checks whether this country has no cities.
     * @return true if there are no cities in the country, false otherwise.
     */
    boolean isEmpty();
    /**
     * Searches for a city within the country by its name.*
     * @param name the name of the city to find.
     * @return the CityProject.City object if found, or null if it doesn't exist.
     */
    City findCity(String name);
    /**
     * Returns an iterator over all cities stored in this country.*
     * @return an Iterator over the stored CityProject.City objects.
     * @throws NoSuchElementException if there are no cities available.
     */
    Iterator<City> listCities();
}
