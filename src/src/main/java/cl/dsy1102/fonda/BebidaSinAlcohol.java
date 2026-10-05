package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida{

    private double azucar;

    public BebidaSinAlcohol(
            String nombre,
            int volumen,
            int stock,
            double azucar
    ){
        super(nombre,volumen,stock);
        setAzucar(azucar);;
    }
    public double getAzucar() {
        return azucar;
    }

    public void setAzucar(double azucar) {
        this.azucar = azucar;
    }

    @Override
    public int calcularPrecioVenta() {
        int precioBase = 2000;
        if (azucar > 80) {
            return (int) (precioBase * 1.10);
        }
        return precioBase;
    }
    @Override
    public String fichaDetalle() {
        return "Nombre: " + getNombre()
                + " | Volumen: " + getVolumen() + " ml"
                + " | Stock: " + getStock()
                + " | Azucar: " + azucar + " g/L"
                + " | Precio: $" + calcularPrecioVenta();
    }
}
