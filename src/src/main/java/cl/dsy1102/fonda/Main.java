package cl.dsy1102.fonda;

public class Main {

    public static void main(String[] args) {

        System.out.println("Proyecto listo. Comienza por la clase Bebida.");

//Crear Chicha Alcoholica//
        BebidaAlcoholica chicha = new BebidaAlcoholica(
                "Chicha",
                1000,
                40,
                12.0,
                false,
                true
        );
        System.out.println(chicha);
        System.out.println("Precio: $" + chicha.calcularPrecioVenta());
        System.out.println(chicha.fichaDetalle());

        BebidaSinAlcohol chichaSinAlcohol = new BebidaSinAlcohol(
                "Chicha",
                1000,
                60,
                95
        );

        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol(
                "Mote con Huesillo",
                400,
                50,
                70
        );
        BebidaAlcoholica PiscoSour = new BebidaAlcoholica(
                "Pisco Sour",
                500,
                25,
                18.0,
                true,
                false

        );
        GestorFonda gestor = new GestorFonda();

        gestor.registrarBebida(chicha);
        gestor.registrarBebida(PiscoSour);
        gestor.registrarBebida(chichaSinAlcohol);
        gestor.registrarBebida(moteConHuesillo);

        System.out.println("= BUSQUEDA POR NOMBRE: Chicha =");

        for (Bebida bebida : gestor.buscarPorNombre("Chicha")) {
            System.out.println(bebida.fichaDetalle());
        }
        // Realizar ventas//
        System.out.println("\n= VENTAS =");

        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);


        // Listar todas las bebidas//
        System.out.println("\n= LISTADO DE BEBIDAS =");

        System.out.println(chicha);
        System.out.println(PiscoSour);
        System.out.println(chichaSinAlcohol);
        System.out.println(moteConHuesillo);
    }


        }





