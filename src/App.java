import dataStructures.Iterator;
import dataStructures.exceptions.ElementAlreadyExistsException;
import dataStructures.exceptions.NoSuchElementException;

public interface App {
    void addCity(String city,  String country, int population) throws ElementAlreadyExistsException;
    void removeCity(String city, String country) throws NoSuchElementException;
    int getPopulation(String city, String country) throws NoSuchElementException ;
    Iterator<Country> listCountries()  throws NoSuchElementException ;
}
