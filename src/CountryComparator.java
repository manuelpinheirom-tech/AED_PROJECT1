import dataStructures.Comparator;

import java.io.Serial;
import java.io.Serializable;

/**
 * Comparator for Country objects, ordering them alphabetically by their name (case-insensitive).
 * Space Complexity: O(1) auxiliary space, as the comparator is stateless and
 * only holds the serialVersionUID constant.
 */
public class CountryComparator implements Comparator<Country>, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Compares two Country objects based on their names.
     * Time Complexity:
     * - Best case: O(1) (if the names differ at the first character, the comparison returns immediately).
     * - Worst case: O(L) where L is the length of the shorter country name string.
     *   This happens when the names are identical or differ only at the very end, requiring
     *   a character-by-character evaluation by compareToIgnoreCase.
     *
     * @param a the first country to be compared.
     * @param b the second country to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     *         equal to, or greater than the second.
     */
    @Override
    public int compare(Country a, Country b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}