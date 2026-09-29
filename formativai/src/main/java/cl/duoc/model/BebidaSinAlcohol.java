package cl.duoc.model;

public class BebidaSinAlcohol extends Bebida {
    private int azucarPorLitro;

    public BebidaSinAlcohol(String nombre, int volumenML, int stock, int azucarPorLitro) {
        if (azucarPorLitro < 0) {
            throw new IllegalArgumentException("[ERROR] - La cantidad de azucar no puede ser un valor negativo.");
        }
        super(nombre, volumenML, stock);
        this.azucarPorLitro = azucarPorLitro;
    }

    public int getAzucarPorLitro() { return azucarPorLitro; }
    public void setAzucarPorLitro(int azucarPorLitro) {
        this.azucarPorLitro = azucarPorLitro;
    }

    public double calcularPrecio(){
        double precio = 2000;
        if (azucarPorLitro > 80){
            precio = (precio * 1.1);
        }
        return precio;
    }
    public String getDetalle(){
        return ("============================================\n" +
                "Nombre:           %s\n" +
                "Volumen(ml):      %s\n" +
                "Stock:            %d\n" +
                "Azucar/L(g):      %d\n" +
                "Precio:           $%.0f\n" +
                "============================================\n").formatted(getNombre(), getAzucarPorLitro(),getStock(),azucarPorLitro, calcularPrecio());
    }
}
