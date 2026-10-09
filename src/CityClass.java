import java.io.Serializable;

public class CityClass implements City, Serializable {
    private static final long serialVersionUID = 0L;

    private final int population;
    private final String name;

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


}
