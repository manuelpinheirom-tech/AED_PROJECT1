import dataStructures.Comparator;
import java.io.Serializable;

public class CityComparator implements Comparator<City>, Serializable {
    private static final long serialVersionUID = 0L;

    @Override
    public int compare(City a, City b) {
        int cmp = Integer.compare(b.getPopulation(), a.getPopulation());
        if (cmp != 0)
            return cmp;
        return a.getName().compareToIgnoreCase(b.getName());
    }
}