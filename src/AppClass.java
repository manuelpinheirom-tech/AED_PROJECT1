
import dataStructures.Iterator;
import dataStructures.SortedLinkedList;
import dataStructures.exceptions.ElementAlreadyExistsException;
import dataStructures.exceptions.NoSuchElementException;

import java.io.Serial;
import java.io.Serializable;

public class AppClass implements App, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    SortedLinkedList<Country> countries;

    public AppClass() {
        this.countries = new SortedLinkedList<>(new CountryComparator());
    }

    @Override
    public void addCity(String city, String countryName, int population) throws ElementAlreadyExistsException {
        Country country = findCountry(countryName);
        if (country == null)
            country = addCountry(countryName);
        else if (country.hasCity(city))
            throw new ElementAlreadyExistsException();
        country.addCity(city, population);
    }

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

    @Override
    public int getPopulation(String cityName, String countryName) throws NoSuchElementException {
        Country country = findCountry(countryName);
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

    @Override
    public Iterator<Country> listCountries()  throws NoSuchElementException {
        if (countries.isEmpty()) {
            throw new NoSuchElementException();
        }
        return countries.iterator();
    }

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

    private Country addCountry(String countryName) {
        Country country = new CountryClass(countryName);
        countries.add(country);
        return country;
    }
}


