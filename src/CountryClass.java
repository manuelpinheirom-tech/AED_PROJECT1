import dataStructures.Iterator;
import dataStructures.SortedLinkedList;
import dataStructures.exceptions.NoSuchElementException;

public class CountryClass implements Country {

    SortedLinkedList<City> cities;
    String name;

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
        cities.remove(city);
    }

    @Override
    public City findCity(String name) {
        if(cities.isEmpty()) {
            return null;
        }
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
        if(cities.isEmpty()) {
            return false;
        }
        Iterator<City> itCity = cities.iterator();
        while (itCity.hasNext()) {
            City c = itCity.next();
            if (c.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return cities.isEmpty();
    }
}

