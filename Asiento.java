package TeatroMoro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asiento {
    public static Asiento[] tipoAsientosTeatro = new Asiento[3];

    public  String ubicacion;
    public  int capacidad;
    public double precioBase;

    public Asiento(String ubicacion, int capacidad, double precioBase) {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;

    }

    public static void inicializarAsientos(){
        Asiento.tipoAsientosTeatro[0]= new Asiento("Palco", 40, 5000.0);
        Asiento.tipoAsientosTeatro[1]= new Asiento("Platea", 40, 8000.0);
        Asiento.tipoAsientosTeatro[2]= new Asiento("Vip", 20, 15000.0);
    }







    @Override
    public String toString() {
        return "Ubicacion: " +  ubicacion + '\n' +
                "Asientos Diponibles: " + capacidad + '\n' +
                "Precio Base: " + precioBase +'\n'+
                "";
    }
}




