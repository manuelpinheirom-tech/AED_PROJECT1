public class CityClass implements City{

    final int population;
    final String name;

    public CityClass(int population, String name){
        this.population = population;
        this.name = name;
    }

    @Override
    public String getName (){
        return name;
    }

    @Override
    public int getPopulation() {
        return population;
    }


    /*public int compareTo(City other){
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
    */
}
