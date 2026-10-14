public interface Country extends CountryInfo{
    void addCity(String name, int population);
    void removeCity(String name);
}
