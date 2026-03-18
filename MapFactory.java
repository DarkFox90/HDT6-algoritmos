import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {

    public static Map<String, List<String>> createMap(int type) {
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

    public static Map<String, List<String>> LoadData(int type, String rutaArchivo) {
        Map<String, List<String>> maps = createMap(type);
        List<String[]> inventory = FileReaderUtil.leerInventario(rutaArchivo);

        for (String[] item : inventory) {
            String categoria = item[0];
            String producto = item[1];

            maps.putIfAbsent(categoria, new ArrayList<>());
            maps.get(categoria).add(producto);
        }

        return maps;
    }
}