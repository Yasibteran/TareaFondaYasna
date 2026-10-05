package cl.dsy1102.fonda;

public interface ConsumoResponsable {

    int MAXIMO_UNIDADES = 3;

    boolean isVentaRestringida();

    void setVentaRestringida(boolean ventaRestringida);

    boolean excedeMaximo(int cantidad);
}
