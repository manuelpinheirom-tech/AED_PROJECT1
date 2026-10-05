import dataStructures.Iterator;

public interface App {
    void addCity(String city,  String country, int population);
    void removeCity(String city, String country);
    int getPopulation(String city, String country);
    Iterator<City> listCities();
}
