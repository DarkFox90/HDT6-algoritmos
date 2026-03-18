import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

public class Controller {

    private Map<String, List<String>> inventory;
    private Map<String, Integer> userCollection;

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa que desea usar: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Opción: ");
        int mapType = sc.nextInt();
        sc.nextLine();

        inventory = MapFactory.LoadData(mapType, "Inventory.txt");
        userCollection = new HashMap<>();

        int option = 0;

        while (option != 7) {
            System.out.println("Menu");
            System.out.println("1. Agregar un producto a la colección");
            System.out.println("2. Mostrar la categoría de un producto");
            System.out.println("3. Mostrar datos de mi colección");
            System.out.println("4. Mostrar datos de mi colección, ordenadas por categoría");
            System.out.println("5. Mostrar el producto y la categoría de todo el inventario");
            System.out.println("6. Mostrar el producto y la categoría existentes, ordenadas por categoría");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre exacto del producto que desea agregar: ");
                    String productToAdd = sc.nextLine();
                    String foundCategory = searchCategory(inventory, productToAdd);

                    if (foundCategory != null) {
                        userCollection.put(productToAdd, userCollection.getOrDefault(productToAdd, 0) + 1);
                        System.out.println("Producto agregado (" + foundCategory + ")");
                    } else {
                        System.out.println("Error, el producto '" + productToAdd + "' no se encuentra en el inventario disponible");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto para buscar su categoría: ");
                    String productToSearch = sc.nextLine();
                    String category = searchCategory(inventory, productToSearch);

                    if (category != null) {
                        System.out.println("El producto '" + productToSearch + "' pertenece a la categoría: " + category);
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Colección");
                    if (userCollection.isEmpty()) {
                        System.out.println("Tu colección está vacía");
                    } else {
                        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                            String prod = entry.getKey();
                            int quantity = entry.getValue();
                            String cat = searchCategory(inventory, prod);
                            System.out.println("Categoría: " + cat + " | Producto: " + prod + " | Cantidad: " + quantity);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Colección ordenada por categoría");
                    if (userCollection.isEmpty()) {
                        System.out.println("Tu colección está vacía");
                    } else {
                        Map<String, Map<String, Integer>> sortedCollection = new TreeMap<>();

                        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                            String prod = entry.getKey();
                            int quantity = entry.getValue();
                            String cat = searchCategory(inventory, prod);

                            sortedCollection.putIfAbsent(cat, new HashMap<>());
                            sortedCollection.get(cat).put(prod, quantity);
                        }

                        for (Map.Entry<String, Map<String, Integer>> catEntry : sortedCollection.entrySet()) {
                            for (Map.Entry<String, Integer> prodEntry : catEntry.getValue().entrySet()) {
                                System.out.println("Categoría: " + catEntry.getKey() + " | Producto: " + prodEntry.getKey() + " | Cantidad: " + prodEntry.getValue());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Inventario");
                    for (Map.Entry<String, List<String>> entry : inventory.entrySet()) {
                        String cat = entry.getKey();
                        for (String prod : entry.getValue()) {
                            System.out.println("Categoría: " + cat + " | Producto: " + prod);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Inventario ordenado por categoría");
                    Map<String, List<String>> sortedInventory = new TreeMap<>(inventory);
                    for (Map.Entry<String, List<String>> entry : sortedInventory.entrySet()) {
                        String cat = entry.getKey();
                        for (String prod : entry.getValue()) {
                            System.out.println("Categoría: " + cat + " | Producto: " + prod);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Gracias por usar el programa");
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
        sc.close();
    }

    private String searchCategory(Map<String, List<String>> inventory, String productToSearch) {
        for (Map.Entry<String, List<String>> entry : inventory.entrySet()) {
            for (String product : entry.getValue()) {
                if (product.trim().equalsIgnoreCase(productToSearch.trim())) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}