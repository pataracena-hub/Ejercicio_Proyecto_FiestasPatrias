package cl.duoc;

import cl.duoc.model.BebidaAlcoholica;
import cl.duoc.model.BebidaSinAlcohol;
import cl.duoc.repository.GestorFonda;

public class Main {
    static void main() {
        GestorFonda fondaSanBelarmino = new GestorFonda();

        try {
            BebidaAlcoholica chichaAdulto = new BebidaAlcoholica(
                    "Chicha",
                    750,
                    10,
                    5,
                    7.0,
                    false,
                    true
            );
            //chichaAdulto.setCertificada(false); //en caso de no restringir durante la creacion (constructor)
            fondaSanBelarmino.agregarBebida(chichaAdulto);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        try {
            BebidaAlcoholica piscoSour = new BebidaAlcoholica(
                    "Pisco Sour",
                    500,
                    25,
                    3,
                    18.0,
                    true,
                    false
            );
            fondaSanBelarmino.agregarBebida(piscoSour);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        try {
            BebidaSinAlcohol chichaMenores = new BebidaSinAlcohol(
                    "Chicha",
                    1000,
                    60,
                    95
            );
            fondaSanBelarmino.agregarBebida(chichaMenores);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        try {
            BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol(
                    "Mote Con Huesillo",
                    400,
                    50,
                    70
            );
            fondaSanBelarmino.agregarBebida(moteConHuesillo);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        System.out.println("============= VENTA DE BEBIDAS =============");
        fondaSanBelarmino.mostrarPorNombre("mote");
        fondaSanBelarmino.venderBebida("pisco sour", 2);
        fondaSanBelarmino.venderBebida("pisco sour", 5);
        fondaSanBelarmino.venderBebida("chicha", 1);
        fondaSanBelarmino.venderBebida("mote con huesillo", 600);
        System.out.println("================ FIN VENTAS ================");

        fondaSanBelarmino.mostrarTodas();
    }

}
