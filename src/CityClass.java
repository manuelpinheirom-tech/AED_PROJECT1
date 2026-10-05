public class CityClass implements City{

    String country;
    int inhabitants;
    String name;

    public CityClass(String country, int inhabitants, String name){
        this.country = country;
        this.inhabitants = inhabitants;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public String getName (){
        return name;
    }
    public int getInhabitants() {
        return inhabitants;
    }

    public int compareTo(City other){
        int countryComp = this.country.compareToIgnoreCase(other.getCountry());
        if(countryComp != 0){
            return countryComp;
        }
        int popComp = Integer.compare(other.getInhabitants(), this.inhabitants);
        if(popComp != 0){
            return popComp;
        }
        return this.name.compareToIgnoreCase(other.getName());
    }
}
