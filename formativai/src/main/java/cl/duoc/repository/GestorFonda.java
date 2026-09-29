package cl.duoc.repository;

import cl.duoc.model.Bebida;
import cl.duoc.model.BebidaAlcoholica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorFonda {
    private List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public GestorFonda(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Bebida> getBebidas() { return this.bebidas; }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public List<Bebida> buscarPorNombre(String nombreFiltro){
        return bebidas.stream().
                filter(bebida -> bebida.getNombre().toLowerCase()
                        .contains(nombreFiltro.toLowerCase()))
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
    }
    public void mostrarPorNombre(String nombreFiltro){
        System.out.println("============ BEBIDAS POR NOMBRE ============");
        bebidas.forEach(bebida -> {
            if (bebida.getNombre().toLowerCase().contains(nombreFiltro.toLowerCase())){
                System.out.print(bebida.getDetalle());
            }
        });
        System.out.println("=============== FIN BUSQUEDA ===============");
    }
    public Bebida obtenerPrimeraPorNombre(String nombreFiltro){
        for (Bebida bebidaActual : bebidas) {
            if (bebidaActual.getNombre().equalsIgnoreCase(nombreFiltro)) {
                return bebidaActual;
            }
        }
        System.out.println("[INFO] - No se ha encontrado ninguna coincidencia con nombre: '%s'".formatted(nombreFiltro));
        return null;
    }

    public void mostrarTodas() {
        System.out.println("=========== LISTADO DE BEBIDAS ===========");
        for (Bebida bebidaActual : bebidas) {
            System.out.print(bebidaActual.toString());
        }
        System.out.println("==============  FIN  LISTADO  ==============");
    }
    public void venderBebida(String nombre, int cantidad){
        Bebida bebida = obtenerPrimeraPorNombre(nombre);
        if (bebida == null) { return; }
        System.out.println("[INFO] - Procesando venta de %d x '%s'".formatted(cantidad, bebida.getNombre()));

        if (bebida.getClass().getSimpleName().equals("BebidaAlcoholica")) {
            if (((BebidaAlcoholica) bebida).getLimiteUnidadesPorCliente() < cantidad) {
                System.out.println("[ERROR] - %d uds de '%s' superan el limite de %d uds por cliente".formatted(cantidad, bebida.getNombre(), ((BebidaAlcoholica) bebida).getLimiteUnidadesPorCliente()));
                System.out.println("[INFO] - Compra rechazada");
                return;
            }
            if (((BebidaAlcoholica) bebida).isVentaRestringida()) {
                System.out.println("[ERROR] - '%s' Tiene venta restringida".formatted(bebida.getNombre()));
                System.out.println("[INFO] - Compra rechazada");
                return;
            }
        }

        int nuevoStock = bebida.getStock()-cantidad;
        if (nuevoStock<0) {//d
            System.out.println("[ERROR] - Stock (%d) de '%s' sobrepasado por la cantidad solicitada (%d)".formatted(bebida.getStock(), bebida.getNombre(),cantidad));
            System.out.println("[INFO] - Compra rechazada");
            return;
        }

        bebida.setStock(nuevoStock);
        System.out.println("[INFO] - Compra autorizada");
        System.out.println("[INFO] - %d x %s | Total: $%.0f".formatted(cantidad, bebida.getNombre(), bebida.calcularPrecio()*cantidad));
    }
}
