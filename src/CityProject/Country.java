package CityProject;

public interface Country extends CountryInfo{
    /**
     * Adds a new city to the country.*
     * @param name the name of the city.
     * @param population the population of the city.
     */
    void addCity(String name, int population);
    /**
     * Removes a city from the country by its name.*
     * @param name the name of the city to remove.
     */
    void removeCity(String name);
}
