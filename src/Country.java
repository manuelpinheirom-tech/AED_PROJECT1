import dataStructures.Iterator;

public interface Country {
    String getName();
    boolean hasCity(String name);
    boolean isEmpty();
    void addCity(String name, int population);
    void removeCity(String name);
    City findCity(String name);
    Iterator<City> listCities();
}
