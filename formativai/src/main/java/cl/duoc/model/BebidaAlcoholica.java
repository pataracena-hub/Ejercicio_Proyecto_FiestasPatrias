package cl.duoc.model;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable{

    private final int LIMITE_UNIDADES_POR_CLIENTE;
    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;

    public BebidaAlcoholica(String nombre, int volumenML, int stock, int limiteUdsCliente, double gradosAlcohol, boolean certificada, boolean ventaRestringida) {
        if (limiteUdsCliente <= 0) {
            throw new IllegalArgumentException("[ERROR] - Limite de unidades por cliente debe ser superio a 0");
        }
        if (gradosAlcohol <= 0.5 || gradosAlcohol >= 45) {
            throw new IllegalArgumentException("[ERROR] - Los grados de alcohol deben estar entre 0.5° y 45°");
        }

        super(nombre, volumenML, stock);
        this.LIMITE_UNIDADES_POR_CLIENTE = limiteUdsCliente;
        this.gradosAlcohol = gradosAlcohol;
        this.certificada = certificada;
        this.ventaRestringida = ventaRestringida;
    }

    //Getter
    public int getLimiteUnidadesPorCliente() { return LIMITE_UNIDADES_POR_CLIENTE; }
    public double getGradosAlcohol() { return gradosAlcohol; }
    public boolean isCertificada() { return certificada; }
    public boolean isVentaRestringida() { return ventaRestringida; }

    public String isCertificadaLegible() {
        return certificada ? "Si": "No";
    }
    public String isVentaRestringidaLegible() {
        return ventaRestringida ? "Si": "No";
    }

    //Setter zkrd
    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }
    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }
    public void setVentaRestringida(boolean ventaRestringida) {
        this.ventaRestringida = ventaRestringida;
    }

    public double calcularPrecio(){
        double precio = 3560;
        if (!certificada){
            precio = (precio * 1.2);
        }
        return precio;
    }
    public String getDetalle(){
        return ("============================================\n" +
                "Nombre:           %s\n" +
                "Volumen(ml):      %s\n" +
                "Stock:            %d\n" +
                "Grados Alcohol:   %.1f\n" +
                "Certificada       %s\n" +
                "Restringida:      %s\n" +
                "Precio:           $%.0f\n" +
                "============================================\n").formatted(getNombre(), getVolumenML(), getStock(), gradosAlcohol, isCertificadaLegible(), isVentaRestringidaLegible(), calcularPrecio());
    }

    public boolean tieneVentaRestringida(){return true;}
    public void restringirVenta() throws InterruptedException {
        if (ventaRestringida) {
            throw new InterruptedException("[Error] - Operacion interrumpida. Venta cancelada (Venta restringida)");
        }
    }
    public boolean superaLimite(){return true;}


}
