package TeatroMoro;

import java.util.Random;

public class Cliente {
    public static String nombre;
    public static int edad;
    public static int idCliente;
    public static String descuentoCliente;
    public static double valorDescuento;

    public Cliente(String nombre, int edad, int id, String descuentoCliente) {
        Cliente.nombre = nombre;
        Cliente.edad = edad;
        idCliente = id;
        Cliente.descuentoCliente= descuentoCliente;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getId() {
        return idCliente;
    }
    public void setId(int id) {
        this.idCliente = id;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "Id: " + idCliente + '\n' +
                descuentoCliente;

    }

    public static void randomIdCliente(){
        Random random= new Random();
        idCliente = random.nextInt(100) + 1;
        //System.out.println("Id Cliente: " + idCliente);

    }

    public static void DescuentoCliente(){
        if(Cliente.edad<=18 && Cliente.edad !=0){
            descuentoCliente = "Estudiante: 10% Dcto";
            System.out.println("¡Felicidades posees descuento Estudiante!");
            System.out.println("Aplica un 10% Dcto sobre el valor de tu compra");
            Cliente.valorDescuento = 0.9;
            Descuentos descuentos = new Descuentos("Estudiante", "10%", 0.9);

        } else if (Cliente.edad>=60) {
            descuentoCliente = "Adulto Mayor: 15% Dcto";
            System.out.println("¡Felicidades posees descuento Adulto Mayor!");
            System.out.println("Aplica un 15% Dcto sobre el valor de tu compra");
            Cliente.valorDescuento = 0.85;
            Descuentos descuentos = new Descuentos("Adulto Mayor", "15%", 0.85);
        }else{
            descuentoCliente = "NO posees Dcto";
            Cliente.valorDescuento= 1;
        }

    }
}