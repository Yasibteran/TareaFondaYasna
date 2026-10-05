package cl.dsy1102.fonda;
/*clase Bebida*/
public abstract class Bebida {
    protected String nombre;
    protected int volumen;
    protected int stock;

    //Metodos//
// constructor  es siempre publico//
public Bebida(
        String nombre,
        int volumen,
        int stock
){
    setNombre(nombre);
    setVolumen(volumen);
    setStock(stock);
}
public String getNombre(){
    return nombre;
}
//Si el nombre es null o el nombre esta vacio//
    //nombre.trim() elimina los espacios que estan al principio y al final//
    //nombre.trim().isEmpty() si el texto esta vacio isEmpy da True//
    //  throw new IllegalArgumentException("El nombre no puede ser nulo ni vacio.") esto signiifca que el dato que me entregaron
    // no sirve ,entonces lanzo un error//

    public void setNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacio.");
        }
// this. nombre es el atributo de la clase.
        //nombre es el dato que recibe el metodo
        this.nombre = nombre;

    }
    // Si el volumen  es menor a 100 o mayor a 3000
    // throw new IllegalArgumentException("El volumen debe estar entre 100 y 3000 ml.") esto lanza el error
    public int getVolumen(){
        return volumen;
    }
    public void setVolumen(int volumen){
        if (volumen < 100 || volumen > 3000) {
            throw new IllegalArgumentException("El volumen debe estar entre 100 y 3000 ml.");
        }

        this.volumen = volumen;
    }

public int getStock(){
    return stock;
}
// if  si el stock es menor o igual a cero
    public void setStock(int stock){
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor que 0.");
        }

        this.stock = stock;
    }
/*Aumentar cantidad de bebidas disponibles*/

public void aumentarStock(int cantidad){
    stock += cantidad;
}
/*Disminuye la cantidad de bebidas que hay en el stock*/

public void disminuirStock(int cantidad){
    stock -= cantidad;
}

    // Calcular precio
    public abstract int calcularPrecioVenta();
    public abstract String fichaDetalle();

/* Muestra los datos de la bebida*/
    @Override
    public String toString(){
        return "Nombre: " + nombre + " | Volumen: " + volumen + " ml";
    }

}
