import dataStructures.Comparator;

import java.io.Serial;
import java.io.Serializable;

/**
 * Comparator for City objects, ordering them by population (descending)
 * and then by name alphabetically (case-insensitive).
 * Space Complexity: O(1) auxiliary space, as it only holds no state other
 * than the serialVersionUID constant.
 */
public class CityComparator implements Comparator<City>, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Compares two City objects.
     * Time Complexity:
     * - Best case: O(1) (if the populations are different, it returns immediately after an integer comparison).
     * - Worst case: O(L) where L is the length of the shorter city name string. This occurs when
     *   populations are equal, requiring a character-by-character string comparison (compareToIgnoreCase).
     *
     * @param a the first city to be compared.
     * @param b the second city to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     *         equal to, or greater than the second.
     */
    @Override
    public int compare(City a, City b) {
        int cmp = Integer.compare(b.population(), a.population());
        if (cmp != 0)
            return cmp;
        return a.name().compareToIgnoreCase(b.name());
    }
}