import java.io.Serial;
import java.io.Serializable;

/**
 * A record representing a city, containing its population and name.
 * Space Complexity: O(1) auxiliary space per instance, as it simply stores
 * a primitive integer and a String reference.
 * Note on Time Complexity for implicitly generated methods:
 * - Best and Worst case: O(1). The implicitly generated accessors
 *   (population() and name()), as well as the constructor, operate in
 *   strict constant time.
 * @param population the number of inhabitants in the city.
 * @param name the name of the city.
 */
public record CityClass(int population, String name) implements City, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

}