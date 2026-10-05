package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {

    private double graduacionAlcoholica;
    private boolean certificada;
    private boolean ventaRestringida;

    // Constructor
    public BebidaAlcoholica(
            String nombre,
            int volumen,
            int stock,
            double graduacionAlcoholica,
            boolean certificada,
            boolean ventaRestringida
    ) {
        super(nombre, volumen, stock);

        setGraduacionAlcoholica(graduacionAlcoholica);
        setCertificada(certificada);
        setVentaRestringida(ventaRestringida);
    }

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    public boolean isVentaRestringida() {
        return ventaRestringida;
    }

    public void setVentaRestringida(boolean ventaRestringida) {
        this.ventaRestringida = ventaRestringida;
    }

    // Validamos los grados de alcohol
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {

        if (graduacionAlcoholica < 0.5 || graduacionAlcoholica > 45) {
            throw new IllegalArgumentException(
                    "La graduacion alcoholica debe estar entre 0.5 y 45 grados."
            );
        }

        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    // Calcula el precio de venta
    @Override
    public int calcularPrecioVenta() {

        int precioBase = 3500;

        if (!certificada) {
            return (int) (precioBase * 1.20);
        }

        return precioBase;
    }
    @Override
    public String fichaDetalle() {
        return "Nombre: " + getNombre()
                + " | Volumen: " + getVolumen() + " ml"
                + " | Stock: " + getStock()
                + " | Graduacion alcoholica: " + graduacionAlcoholica
                + " | Certificada: " + certificada
                + " | Venta restringida: " + ventaRestringida
                + " | Precio: $" + calcularPrecioVenta();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean excedeMaximo(int cantidad) {
        return cantidad > MAXIMO_UNIDADES;
    }
}