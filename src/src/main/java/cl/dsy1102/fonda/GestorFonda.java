package cl.dsy1102.fonda;

import java.util.ArrayList;

public class GestorFonda {

    private ArrayList<Bebida> bebidas;

    public GestorFonda() {
        bebidas = new ArrayList<>();
    }

    public void registrarBebida(Bebida bebida) {
        bebidas.add(bebida);
        System.out.println("Bebida incorporada correctamente.");
    }

    public ArrayList<Bebida> buscarPorNombre(String nombre) {

        ArrayList<Bebida> resultados = new ArrayList<>();

        for (Bebida bebida : bebidas) {

            if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(bebida);
            }
        }

        return resultados;
    }

    public void vender(String nombre, int cantidad) {

        Bebida bebidaEncontrada = null;

        for (Bebida bebida : bebidas) {

            if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                bebidaEncontrada = bebida;
                break;
            }
        }

        if (bebidaEncontrada == null) {
            System.out.println("Bebida no encontrada.");
            return;
        }

        if (bebidaEncontrada instanceof ConsumoResponsable) {

            ConsumoResponsable consumo =
                    (ConsumoResponsable) bebidaEncontrada;

            if (consumo.isVentaRestringida()) {
                System.out.println(
                        "Venta rechazada: la bebida tiene venta restringida."
                );
                return;
            }

            if (consumo.excedeMaximo(cantidad)) {
                System.out.println(
                        "Venta rechazada: supera el maximo permitido."
                );
                return;
            }
        }

        int total =
                cantidad * bebidaEncontrada.calcularPrecioVenta();

        System.out.println(
                "Venta autorizada: "
                        + cantidad + " x "
                        + bebidaEncontrada.getNombre()
                        + " | Total: $" + total
        );
    }
}