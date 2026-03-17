public class Product {
    private String categoria;
    private String producto;

    public Product(String categoria, String producto) {
        this.categoria = categoria;
        this.producto = producto;
    }

    public String getCategoria() {
        return this.categoria;
    }

    
    public String getProducto() {
        return this.producto;
    }

    @Override
    public String toString(){
        return categoria + "|" + producto;
    }

}
