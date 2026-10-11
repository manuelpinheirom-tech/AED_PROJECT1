import dataStructures.Comparator;

import java.io.Serial;
import java.io.Serializable;

public class CityComparator implements Comparator<City>, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    @Override
    public int compare(City a, City b) {
        int cmp = Integer.compare(b.population(), a.population());
        if (cmp != 0)
            return cmp;
        return a.name().compareToIgnoreCase(b.name());
    }
}