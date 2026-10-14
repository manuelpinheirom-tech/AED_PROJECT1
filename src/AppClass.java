import dataStructures.Iterator;
import dataStructures.SortedLinkedList;
import dataStructures.exceptions.ElementAlreadyExistsException;
import dataStructures.exceptions.NoSuchElementException;

import java.io.Serial;
import java.io.Serializable;

/**
 * Implementation of the App interface, managing a collection of countries and their cities.
 * Space Complexity: O(P + C), where P is the total number of countries and C is the total 
 * number of cities stored across all countries.
 */
public class AppClass implements App, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    SortedLinkedList<Country> countries;

    /**
     * Constructor for AppClass.
     * Time Complexity:
     * - Best and Worst case: O(1) to initialize the empty sorted linked list.
     */
    public AppClass() {
        this.countries = new SortedLinkedList<>(new CountryComparator());
    }

    /**
     * Adds a new city to the specified country.
     * Time Complexity:
     * - Best case: O(1) (if the country and city are inserted at the beginning of their respective lists).
     * - Worst case: O(P + C) where P is the number of countries and C is the number of cities in the specified country.
     *   (Requires finding the country in O(P), checking for city existence in O(C), and inserting the city in O(C)).
     * @param city the name of the city.
     * @param countryName the name of the country.
     * @param population the population of the city.
     * @throws ElementAlreadyExistsException if the city already exists in the given country.
     */
    @Override
    public void addCity(String city, String countryName, int population) throws ElementAlreadyExistsException {
        Country country = findCountry(countryName);
        if (country == null)
            country = addCountry(countryName);
        else if (country.hasCity(city))
            throw new ElementAlreadyExistsException();
        country.addCity(city, population);
    }

    /**
     * Removes a city from the specified country. If the country becomes empty, it is also removed.
     * Time Complexity:
     * - Best case: O(1) (if the country and city are at the start of the lists).
     * - Worst case: O(P + C) where P is the number of countries and C is the number of cities in the country.
     *   (Finding the country takes O(P), finding/removing the city takes O(C), and optionally removing the country takes O(P)).
     * @param city the name of the city to remove.
     * @param countryName the name of the country.
     * @throws NoSuchElementException if the country or city does not exist.
     */
    @Override
    public void removeCity(String city, String countryName) throws NoSuchElementException {
        Country country = findCountry(countryName);
        if (country == null || !country.hasCity(city)) {
            throw new NoSuchElementException();
        }
        country.removeCity(city);
        if (country.isEmpty())
            countries.remove(country);
    }

    /**
     * Retrieves the population of a specific city.
     * Time Complexity:
     * - Best case: O(1) (if the country and city are the first elements).
     * - Worst case: O(P + C) where P is the number of countries and C is the number of cities in the country.
     * @param cityName the name of the city.
     * @param countryName the name of the country.
     * @return the population of the city.
     * @throws NoSuchElementException if the country or city is not found.
     */
    @Override
    public int getPopulation(String cityName, String countryName) throws NoSuchElementException {
        CountryInfo country = findCountry(countryName);
        City city;
        if (country == null) {
            throw new NoSuchElementException();
        }
        city = country.findCity(cityName);
        if (city == null) {
            throw new NoSuchElementException();
        }
        return city.population();
    }

    /**
     * Returns an iterator over the countries stored in the application.
     * Time Complexity:
     * - Best and Worst case: O(1) to create and return the iterator.
     * @return an Iterator over the stored Country objects.
     * @throws NoSuchElementException if there are no countries available.
     */
    @Override
    public Iterator<Country> listCountries() throws NoSuchElementException {
        if (countries.isEmpty()) {
            throw new NoSuchElementException();
        }
        return countries.iterator();
    }

    /**
     * Helper method to find a country by its name.
     * Time Complexity:
     * - Best case: O(1) (list is empty or the country is the first element).
     * - Worst case: O(P) where P is the number of countries in the sorted linked list.
     * @param countryName the name of the country to search for.
     * @return the Country object if found, or null otherwise.
     */
    private Country findCountry(String countryName) {
        if (countries.isEmpty()) {
            return null;
        }
        Iterator<Country> iterator = countries.iterator();
        while (iterator.hasNext()) {
            Country country = iterator.next();
            if(country.getName().equalsIgnoreCase(countryName)){
                return country;
            }
        }
        return null;
    }

    /**
     * Helper method to add a new country to the application.
     * Time Complexity:
     * - Best case: O(1) (if inserted at the head of the sorted list).
     * - Worst case: O(P) where P is the number of currently stored countries, as insertion 
     *   in a sorted linked list requires traversing elements to find the correct position.
     * @param countryName the name of the new country.
     * @return the newly created Country object.
     */
    private Country addCountry(String countryName) {
        Country country = new CountryClass(countryName);
        countries.add(country);
        return country;
    }
}