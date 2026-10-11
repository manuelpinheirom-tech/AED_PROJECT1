import java.io.Serial;
import java.io.Serializable;

public record CityClass(int population, String name) implements City, Serializable {

    @Serial
    private static final long serialVersionUID = 0L;


}
