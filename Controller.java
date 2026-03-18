import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Controller {
    

    public void start() {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> maps = MapFactory.LoadData(1, "Inventory.txt");
        
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("seleccione que tipo de mapa desea usar: ");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.println("4. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Que accion desea realizar?");
                    System.out.println("1. agregar producto ");
                    System.out.println("2. mostrar categoria de producto");
                    System.out.println("3. mostrar datos de producto");
                    System.out.println("4. mostrar datos de articulos de su coleccion");
                    System.out.println("5. mostrar producto y categoria del inventario");
                    System.out.println("6. mostrar productos y categorias existentes");
                    System.out.println("7. salir");

                    int opcion2 = sc.nextInt();

                    switch (opcion2) {
                        case 1:
                           
                            break;
                        case 2:

                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        case 5:

                            break;
                        case 6:
                            System.out.println("Categoría|Producto");
                            for (Map.Entry<String, List<String>> entry : maps.entrySet()) {
                                String categoria = entry.getKey();
                                List<String> productos = entry.getValue();

                                for (String producto : productos) {
                                    System.out.println(categoria + "|" + producto);
                                }
                            }
                            break;
                        case 7:
                            System.out.println("gracias por utilizar el programa");
                            sc.close();
                            break;
                        default:
                            throw new AssertionError();
                    }

                    break;
                case 2:
                   
                    System.out.println(maps);
                case 3:
                    
                    System.out.println(maps);
                case 4:
                    System.out.println("gracias por usar el programa");
                    break;
                default:
                    throw new AssertionError();
            }
        }
        sc.close();
    }
}
