import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {

    public static Map<String, String> createMap(int type) {
        switch (type) {
            case 1:
                return new HashMap<>(); 
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción inválida, debe ser 1, 2 o 3");
        }
    }
}