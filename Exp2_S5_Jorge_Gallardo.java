import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    static String nombre;
    static int edad = 0;

    static int totalAsientosSeleccionados =0;
    static float compra;
    static int compraValorNeto;
    static float totalCompra;
    static String ubicacionAsiento;
    static ArrayList asientoId = new ArrayList<>();
    static int eleccionMenu;
    static int buscarEntrada;
}

class Teatro {

    // Capacidad Teatro
    static int capacidadGeneralAsientos = 100;
    static int asientosDisponiblesPalco = 60;
    static int asientosDisponilesPlatea = 30;
    static int asientosDisponilesVip = 10;

    // Ventas
    static int entradasVendidas = 0;
    static int totalVendido = 0;
    static String ubicacionAsiento = "";


    // Valores
    static int valorEntradaPalco= 5000;
    static int valorEntradaPlatea=8000;
    static int valorEntradaVip= 15000;

    // Descuentos
    static String descuentoBaseEstudiante = "Estudiante 10%";
    static String descuentoBaseAdultoMayor = "Adulto Mayor 15%";

    static float descuentoEstudiante= 0.9f;
    static float descuentoAdultoMayor= 0.85f;
    static float descuentoExtra= 0.9f;
    static int sinDescuento= 1;

    public static void informacionGeneralTeatro () {
        System.out.println("Asientos:");
        System.out.println("Capacidad general de Asientos: " + capacidadGeneralAsientos);
        System.out.println("Asientos disponibles Palco: " + asientosDisponiblesPalco);
        System.out.println("Asientos disponibles Platea: " + asientosDisponilesPlatea);
        System.out.println("Asientos disponibles Vip: " + asientosDisponilesVip);
        System.out.println();
        System.out.println("Valores:");
        System.out.println("Valor entrada Palco: " + valorEntradaPalco);
        System.out.println("Valor entrada Platea: " + valorEntradaPlatea);
        System.out.println("Valor entrada Vip: " + valorEntradaVip);
        System.out.println();
        System.out.println("Descuentos Base:");
        System.out.println(descuentoBaseEstudiante);
        System.out.println(descuentoBaseAdultoMayor);



    }

    public static void saludo(){

        Cliente cliente = new Cliente();

        System.out.println();
        System.out.println("Bienvenido al Teatro Moro!");
        System.out.println("Para una mejor atencion ingresa tu nombre:");

        Scanner scanner = new Scanner(System.in);
        cliente.nombre = scanner.next();

        System.out.println();
        System.out.println("Bienvenido " + cliente.nombre +"!");
        System.out.println("Por favor ingresa tu edad para corroborar si tienes algun descuento:");
        Cliente.edad = scanner.nextInt();

        if (Cliente.edad < 18){
            System.out.println();
            System.out.println("Eres Menor de edad!");
            System.out.println("Posees un descuento del 10% sobre el valor de tu compra!");

        } else if (Cliente.edad > 60) {
            System.out.println();
            System.out.println("Eres Adulto Mayor!");
            System.out.println("Posees un descuento del 15% sobre el valor de tu compra!");

        }else {
            System.out.println("No posees descuento por tramos etario");
        }

    }

    public static void menuAtencion(){

        System.out.println();
        System.out.println("*** Menu Atencón Teatro Moro ***");

        System.out.println();
        System.out.println(Cliente.nombre + "!");
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("Ingresa tu opción:");
        System.out.println();
        System.out.println("*************************");
        System.out.println("1. Informacion General Teatro");
        System.out.println("2. Comprar");
        System.out.println("3. Promociones adicionales");
        System.out.println("4. Buscar entradas");
        System.out.println("5. Eliminar entrada");
        System.out.println("6. Carrito de Compras");
        System.out.println("7. Salir");
        System.out.println("*************************");

        Scanner scanner = new Scanner(System.in);
        Cliente.eleccionMenu = scanner.nextInt();





    }

    public static void compra(){
        System.out.println();
        System.out.println("*** Compra ***");
        System.out.println();
        System.out.println(Cliente.nombre + " Te encuentras en la sección de compra!");
        System.out.println();
        System.out.println("Elige la ubicacion: \nPalco \nPleatea\nVip ");

        Scanner scanner= new Scanner(System.in);
        Cliente.ubicacionAsiento = scanner.next();

        switch (Cliente.ubicacionAsiento.toLowerCase()) {

            case "palco":
                System.out.println("El valor de la entrada Palco es de " + valorEntradaPalco);
                System.out.println("Cuantas entradas deseas?");
                scanner = new Scanner(System.in);
                Cliente.totalAsientosSeleccionados = scanner.nextInt();

                Cliente.compraValorNeto = Cliente.totalAsientosSeleccionados*valorEntradaPalco;

                for(int i= 0; i < Cliente.totalAsientosSeleccionados; i++ ){
                    System.out.println("Selecciona el numero de asiento");
                    Cliente.asientoId.add(scanner.nextInt());
                }

                if (Cliente.totalAsientosSeleccionados >=3){
                    Cliente.compra= Cliente.totalAsientosSeleccionados*valorEntradaPalco*Teatro.descuentoExtra;
                    carritoCompras();
                }else {
                    Cliente.compra = Cliente.totalAsientosSeleccionados * valorEntradaPalco;
                    carritoCompras();
                }
                Teatro.capacidadGeneralAsientos = Teatro.capacidadGeneralAsientos - Cliente.totalAsientosSeleccionados;
                Teatro.asientosDisponiblesPalco = Teatro.asientosDisponiblesPalco - Cliente.totalAsientosSeleccionados;
                break;

            case "platea":
                System.out.println("El valor de la entrada Platea es de " + valorEntradaPlatea);
                System.out.println("Cuantas entradas deseas");
                scanner = new Scanner(System.in);
                Cliente.totalAsientosSeleccionados = scanner.nextInt();

                Cliente.compraValorNeto = Cliente.totalAsientosSeleccionados*valorEntradaPlatea;

                for(int i= 0; i < Cliente.totalAsientosSeleccionados; i++ ){
                    System.out.println("Selecciona el numero de asiento");
                    Cliente.asientoId.add(scanner.nextInt());
                }

                if (Cliente.totalAsientosSeleccionados >=3){
                    Cliente.compra= Cliente.totalAsientosSeleccionados*valorEntradaPlatea*Teatro.descuentoExtra;
                    carritoCompras();
                }else {
                    Cliente.compra = Cliente.totalAsientosSeleccionados * valorEntradaPalco;
                    carritoCompras();
                }

                Teatro.capacidadGeneralAsientos = Teatro.capacidadGeneralAsientos - Cliente.totalAsientosSeleccionados;
                Teatro.asientosDisponilesPlatea = Teatro.asientosDisponilesPlatea - Cliente.totalAsientosSeleccionados;

                break;

            case "vip":
                System.out.println("El valor de la entrada Vip es de " + valorEntradaVip);
                System.out.println("¿Cuantas entradas deseas?");
                scanner = new Scanner(System.in);
                Cliente.totalAsientosSeleccionados = scanner.nextInt();

                Cliente.compraValorNeto = Cliente.totalAsientosSeleccionados*valorEntradaVip;

                for(int i= 0; i < Cliente.totalAsientosSeleccionados; i++ ){
                    System.out.println("Selecciona el numero de asiento");
                    Cliente.asientoId.add(scanner.nextInt());
                }

                if (Cliente.totalAsientosSeleccionados >=3){
                    System.out.println("Posees un descuento EXTRA de un 10% sobre tu compra");
                    Cliente.compra= Cliente.totalAsientosSeleccionados*valorEntradaVip*Teatro.descuentoExtra;
                    carritoCompras();
                }else {
                    Cliente.compra = Cliente.totalAsientosSeleccionados * valorEntradaPalco;
                    carritoCompras();
                }

                Teatro.capacidadGeneralAsientos = Teatro.capacidadGeneralAsientos - Cliente.totalAsientosSeleccionados;
                Teatro.asientosDisponilesVip = Teatro.asientosDisponilesVip - Cliente.totalAsientosSeleccionados;

                break;

            default:

                System.out.println();
                System.out.println("Accion Invalida");
                System.out.println("Ingresa nuevamente tu preferencia");

        }




    }

    public static void carritoCompras(){

        System.out.println();
        System.out.println("*** Carrito de Compras ***");
        System.out.println();
        System.out.println(Cliente.nombre + " Te encuentras en tu carrito de compras");
        System.out.println("A continuacion vamos a revisar la informacion de tu compra:");

        System.out.println();
        System.out.println("Nombre: " + Cliente.nombre);
        System.out.println("Edad: " + Cliente.edad + " años");
        //Descuento Base
        if (Cliente.edad < 18){

            Cliente.totalCompra = Cliente.compra * Teatro.descuentoEstudiante;


            System.out.println("El valor neto de tu compra es de: " + Cliente.compraValorNeto);
            System.out.println("Descuento Base: " + Teatro.descuentoBaseEstudiante);
            System.out.println("El valor con descuento BASE aplicado: " + Cliente.compra);

            System.out.println("Cantidad de asientos seleccionados: " + Cliente.totalAsientosSeleccionados);
            System.out.println("Ubicacion Asiento: " + Cliente.ubicacionAsiento);
            System.out.println("Numero asientos:" + Cliente.asientoId );

            if(Cliente.totalAsientosSeleccionados>=3){
                System.out.println("Descuento Extra: 10% Dcto");
            }

            System.out.println("Total a pagar: " + Cliente.totalCompra);

            System.out.println();
            System.out.println("Muchas gracias por tu compra");
            System.out.println("Que disfrutes del espectaculo");

        } else if (Cliente.edad > 60) {

            Cliente.totalCompra = Cliente.compra * Teatro.descuentoAdultoMayor;

            System.out.println("El valor neto de tu compra es de: " + Cliente.compraValorNeto);
            System.out.println("Descuento Base: " + Teatro.descuentoBaseAdultoMayor);
            System.out.println("El valor con descuento BASE aplicado: " + Cliente.compra);

            System.out.println("Cantidad de asientos seleccionados: " + Cliente.totalAsientosSeleccionados);
            System.out.println("Ubicacion Asiento: " + Cliente.ubicacionAsiento);
            System.out.println("Numero asientos:" + Cliente.asientoId );

            if(Cliente.totalAsientosSeleccionados>=3){
                System.out.println("Descuento Extra: 10% Dcto");
            }

            System.out.println("Total a pagar: " + Cliente.totalCompra);

            System.out.println();
            System.out.println("Muchas gracias por tu compra");
            System.out.println("Que disfrutes del espectaculo");

        }else{

            System.out.println("El valor neto de tu compra es de: " + Cliente.compra);
            System.out.println("Descuento Base: NO POSEES DESCUENTO");

            System.out.println("Cantidad de asientos seleccionados: " + Cliente.totalAsientosSeleccionados);
            System.out.println("Ubicacion Asiento: " + Cliente.ubicacionAsiento);
            System.out.println("Numero asientos: " + Cliente.asientoId );

            if(Cliente.totalAsientosSeleccionados>=3){
                System.out.println("Descuento Extra: 10% Dcto");
            }

            System.out.println("Total a pagar: " + Cliente.compra);

            System.out.println();
            System.out.println("Muchas gracias por tu compra");
            System.out.println("Que disfrutes del espectaculo");
        }



    }

    public static void buscarEntrada(){
        System.out.println("Ingresa el numero de entrada que deseas buscar");
        Scanner scanner = new Scanner(System.in);
        Cliente.buscarEntrada= scanner.nextInt();
        Cliente.asientoId.contains(Cliente.buscarEntrada);

        if(Cliente.asientoId.contains(Cliente.buscarEntrada)){
            System.out.println("Numero Comprado");
        }else{
            System.out.println("Numero Disponible");
        }

    }

    public static void eliminarEntrada(){
        int eliminarEntrada;


        System.out.println("Ingresa el numero de entrada que deseas eliminar");
        Scanner scanner = new Scanner(System.in);
        Cliente.buscarEntrada= scanner.nextInt();
        Cliente.asientoId.contains(Cliente.buscarEntrada);

        if(Cliente.asientoId.contains(Cliente.buscarEntrada)) {
            System.out.println("Estado Actual: Numero Comprado");
            Cliente.asientoId.remove(Integer.valueOf(Cliente.buscarEntrada));
            System.out.println("Numero Elimindo con éxito");
        }else{
            System.out.println("Este numero no se encuentra en tu carrito de compras");
        }
    }



    }






public class Main {
    public static void main(String[] args) {


        Teatro.saludo();

        do {
            Teatro.menuAtencion();

            switch (Cliente.eleccionMenu) {
                case 1:
                    Teatro.informacionGeneralTeatro();
                    break;

                case 2:
                    Teatro.compra();
                    break;

                case 3:
                    System.out.println("En Teatro Moro tenemos una promoción disponible para ti!");
                    System.out.println("Si realizas una compra de 3 o mas entradas tienes un 10% Dcto EXTRA!");
                    break;

                case 4:
                    Teatro.buscarEntrada();
                    break;

                case 5:
                    Teatro.eliminarEntrada();
                    break;

                case 6:
                    Teatro.carritoCompras();
                    break;

                case 7:
                    System.out.println("Hasta pronto " + Cliente.nombre + "!");
                    System.out.println("Gracias por venir a Teatro Moro!");
                    break;

                default:
                    System.out.println("Accion Incorrecta");



            }


        }while(Cliente.eleccionMenu<6);
    }
}