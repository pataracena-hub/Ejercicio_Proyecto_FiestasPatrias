package cl.duoc.model;

public abstract class Bebida {
    private String nombre;
    private int volumenML;
    private int stock;

    public Bebida(String nombre, int volumenML, int stock) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("[ERROR] - El nombre no puede ser nulo, ni estar en blanco");
        }
        if (volumenML < 100){
            throw new IllegalArgumentException("[ERROR] - La cantidad de mililitros debe ser mayor a 100ml y menor a 3000ml");
        }
        if (stock <= 0) {
            throw new IllegalArgumentException("[ERROR] - El stock debe ser un numero positivo");
        }
        this.nombre    =   nombre;
        this.volumenML =   volumenML;
        this.stock     =   stock;
    }
    // Getter -> Accesadores
    public String getNombre() { return nombre; }
    public int getVolumenML() { return volumenML; }
    public int getStock() { return stock; }

    // Setter -> Mutadores
    public void setVolumenML(int volumenML) {
        this.volumenML = volumenML;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract double calcularPrecio();
    public abstract String getDetalle();

    public String toString(){
        return ("============================================\n" +
                "Nombre:           %s\n" +
                "Volumen(ml):      %d\n" +
                "============================================\n").formatted(nombre ,volumenML);
    }



}

