package CityProject;

import dataStructures.Iterator;
import dataStructures.SortedLinkedList;
import dataStructures.exceptions.NoSuchElementException;

import java.io.Serial;
import java.io.Serializable;

/**
 * Implementation of the CityProject.Country interface, managing a collection of cities.*
 * Space Complexity: O(C) auxiliary space, where C is the number of cities
 * stored within this specific country.
 */
public class CountryClass implements Country, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    private final SortedLinkedList<City> cities;
    private final String name;

    /**
     * Constructor for the CityProject.CountryClass.*
     * Time Complexity:
     * - Best and Worst case: O(1) to initialize the string reference and the empty sorted linked list.
     *
     * @param name the name of the country.
     */
    public CountryClass(String name) {
        cities = new SortedLinkedList<>(new CityComparator());
        this.name = name;
    }

    /**
     * Time Complexity:
     * - Best case: O(1) (if the new city is inserted at the head of the sorted linked list).
     * - Worst case: O(C) where C is the number of cities currently in the country.
     *   (Insertion into a sorted linked list requires traversing to find the correct sorted position).
     */
    @Override
    public void addCity(String city, int population) {
        cities.add(new CityClass(population, city));
    }

    /**
     * Time Complexity:
     * - Best case: O(1) (if the city to remove is the first element in the list).
     * - Worst case: O(C) where C is the number of cities in the country.
     *   (Requires O(C) to find the city and O(C) to remove it from the linked list).
     */
    @Override
    public void removeCity(String name) {
        City city = findCity(name);
        if (city != null)
            cities.remove(city);
    }

    /**
     * Time Complexity:
     * - Best case: O(1) (if the city is the first one in the list).
     * - Worst case: O(C) where C is the number of cities in the country.
     *   (Performs a linear search, iterating through the entire list if the city is at the end or does not exist).
     */
    @Override
    public City findCity(String name) {
        Iterator<City> iterator = cities.iterator();
        while (iterator.hasNext()) {
            City city = iterator.next();
            if(city.name().equalsIgnoreCase(name)){
                return city;
            }
        }
        return null;
    }

    /**
     * Time Complexity:
     * - Best and Worst case: O(1) to create and return the iterator.
     */
    @Override
    public Iterator<City> listCities() {
        if (cities.isEmpty()) {
            throw new NoSuchElementException();
        }
        return cities.iterator();
    }

    /**
     * Time Complexity:
     * - Best and Worst case: O(1).
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Time Complexity:
     * - Best case: O(1) (if the city is the first element in the list).
     * - Worst case: O(C) where C is the number of cities in the country
     *   (as it strictly depends on the findCity method).
     */
    @Override
    public boolean hasCity(String name) {
        return findCity(name) != null;
    }

    /**
     * Time Complexity:
     * - Best and Worst case: O(1) assuming the underlying SortedLinkedList tracks its state/size.
     */
    @Override
    public boolean isEmpty() {
        return cities.isEmpty();
    }
}