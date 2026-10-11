import dataStructures.Comparator;

import java.io.Serial;
import java.io.Serializable;

public class CountryComparator implements Comparator<Country>, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    @Override
    public int compare(Country a, Country b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}