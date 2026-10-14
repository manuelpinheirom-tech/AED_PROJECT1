import dataStructures.Iterator;

public interface CountryInfo  {
    String getName();
    boolean hasCity(String name);
    boolean isEmpty();
    City findCity(String name);
    Iterator<City> listCities();
}
