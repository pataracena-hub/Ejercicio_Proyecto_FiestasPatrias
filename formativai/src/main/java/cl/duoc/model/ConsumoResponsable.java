package cl.duoc.model;

public interface ConsumoResponsable {
    boolean tieneVentaRestringida();
    void restringirVenta() throws InterruptedException;
    boolean superaLimite();
}
