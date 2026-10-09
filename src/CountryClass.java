import dataStructures.Iterator;
import dataStructures.SortedLinkedList;
import dataStructures.exceptions.NoSuchElementException;

import java.io.Serializable;

public class CountryClass implements Country, Serializable {
    private static final long serialVersionUID = 0L;

    private final SortedLinkedList<City> cities;
    private final String name;

    public CountryClass(String name) {
        cities = new SortedLinkedList<>(new CityComparator());
        this.name = name;
    }

    @Override
    public void addCity(String city, int population) {
        cities.add(new CityClass(population, city));
    }

    @Override
    public void removeCity(String name) {
        City city = findCity(name);
        if (city != null)
            cities.remove(city);
    }

    @Override
    public City findCity(String name) {
        Iterator<City> iterator = cities.iterator();
        while (iterator.hasNext()) {
            City city = iterator.next();
            if(city.getName().equalsIgnoreCase(name)){
                return city;
            }
        }
        return null;
    }

    @Override
    public Iterator<City> listCities() {
        if (cities.isEmpty()) {
            throw new NoSuchElementException();
        }
        return cities.iterator();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasCity(String name) {
        return findCity(name) != null;
    }

    @Override
    public boolean isEmpty() {
        return cities.isEmpty();
    }
}

