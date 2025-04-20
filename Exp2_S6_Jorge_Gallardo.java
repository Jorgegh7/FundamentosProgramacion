import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Cliente {

    static String nombre;

    static float compra;
    static int numeroDeCompra;
    static int entradaReservada;

    static ArrayList asientoIdReservaPalco = new ArrayList();
    static ArrayList asientoIdReservaPlatea = new ArrayList();
    static ArrayList asientoIdReservaVip = new ArrayList();

    static Map<String, String> asientoIdComprado = new HashMap<>();

    static int eleccionMenu;

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

    // Valores
    static int valorEntradaPalco= 5000;
    static int valorEntradaPlatea=8000;
    static int valorEntradaVip= 15000;


    public static void saludo(){

        Cliente cliente = new Cliente();

        System.out.println();
        System.out.println("Bienvenido al Teatro Moro!");
        System.out.println("Para una mejor atencion ingresa tu nombre:");

        Scanner scanner = new Scanner(System.in);
        cliente.nombre = scanner.next();

        System.out.println();
        System.out.println("Bienvenido " + cliente.nombre +"!");
        System.out.println("A continuacion será desplegado el Menú de atención");


    }

    public static void menuAtencion(){

        System.out.println();
        System.out.println("*** Menu Atencón Teatro Moro ***");
        System.out.println();
        System.out.println("*************************");
        System.out.println("1. Informacion General Teatro");
        System.out.println("2. Reservar Entradas");
        System.out.println("3. Comprar Entradas");
        System.out.println("4. Modificar Compra");
        System.out.println("5. Imprimir Boleto");
        System.out.println("6. Salir");
        System.out.println("*************************");
        System.out.println();

        System.out.println(Cliente.nombre + "!");
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("Ingresa tu opción:");

        Scanner scanner = new Scanner(System.in);
        Cliente.eleccionMenu = scanner.nextInt();


    }

    public static void informacionGeneralTeatro () {
        System.out.println();
        System.out.println("***Informacion General Teatro***");
        System.out.println();
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



    }

    public static void reservarEntradas(){
        HashMap hashMap = new HashMap();


        String tipoEntradaReserva;

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Te encuentras en el punto de reserva de entradas");
        System.out.println("Puedes reservar un máximo de 2 entradas por ubicacion");

        System.out.println();
        if(!Cliente.asientoIdReservaPalco.isEmpty()){
            System.out.println("Posees estos asientos reservados:");
            System.out.println("Palco: " + Cliente.asientoIdReservaPalco);
        }
        if(!Cliente.asientoIdReservaPlatea.isEmpty()) {
            System.out.println("Posees estos asientos reservados:");
            System.out.println("Platea: " + Cliente.asientoIdReservaPlatea);
        }
        if(!Cliente.asientoIdReservaVip.isEmpty()) {
            System.out.println("Posees estos asientos reservados:");
            System.out.println("Vip: " + Cliente.asientoIdReservaVip);
        }
        System.out.println();

        System.out.println("Ingresa el tipo de entrada que deseas reservar");
        System.out.println();
        System.out.println("Elige la ubicacion: \nPalco \nPleatea\nVip ");

        tipoEntradaReserva = scanner.next(); //Punto de depuración

        switch (tipoEntradaReserva.toLowerCase()){

            case "palco":
                System.out.println("Ingresa un numero hasta 60:");
                Cliente.entradaReservada = scanner.nextInt();
                boolean asientoDisponibleReservado = Cliente.asientoIdReservaPalco.contains(Cliente.entradaReservada);

                if(Cliente.asientoIdReservaPalco.size()==2){
                    System.out.println("Limite máximo de reservas alcanzado");
                } else if (Cliente.entradaReservada<=60 && Cliente.entradaReservada !=0) {
                    System.out.println();
                    System.out.println("Estamos validando la información...");

                    if (asientoDisponibleReservado==true || Cliente.asientoIdComprado.containsValue("Palco " + Cliente.entradaReservada)){
                        System.out.println("Este numero ya ha sido Reservado/Comprado anteriormente");
                    } else{
                        Cliente.asientoIdReservaPalco.add(Cliente.entradaReservada);
                        System.out.println("Has reservado Exitosamente la entrada:");
                        System.out.println("Palco: " + Cliente.entradaReservada);
                        System.out.println("Puedes finalizar tu compra en la seccion Comprar entrada!");
                        --Teatro.asientosDisponiblesPalco;
                    } //Punto de depuración

                }else{
                    System.out.println("Acción Invalida");
                }
                break; //Punto de depuración

            case "platea":
                System.out.println("Ingresa un numero entre 61 y 90:");
                Cliente.entradaReservada = scanner.nextInt();
                asientoDisponibleReservado = Cliente.asientoIdReservaPlatea.contains(Cliente.entradaReservada);

                if(Cliente.asientoIdReservaPlatea.size()==2) {
                    System.out.println("Limite máximo de reservas alcanzado");

                }else if (Cliente.entradaReservada<=90 && Cliente.entradaReservada !=0 && Cliente.entradaReservada>=60) {
                    System.out.println();
                    System.out.println("Estamos validando la información...");

                    if (asientoDisponibleReservado==true || Cliente.asientoIdComprado.containsValue("Platea " + Cliente.entradaReservada)){
                        System.out.println("Este numero ya ha sido Reservado/Comprado anteriormente");
                    }else{
                        Cliente.asientoIdReservaPlatea.add(Cliente.entradaReservada);
                        System.out.println("Has reservado Exitosamente la entrada:");
                        System.out.println("PLATEA: " + Cliente.entradaReservada);
                        System.out.println("Puedes finalizar tu compra en la sección Comprar entrada!");
                        --Teatro.asientosDisponilesPlatea;
                    }

                }else{
                    System.out.println("Acción Invalida");
                }
                break; //Punto de depuración

            case "vip":
                System.out.println("Ingresa un numero entre 91 y 100:");
                Cliente.entradaReservada = scanner.nextInt();
                asientoDisponibleReservado = Cliente.asientoIdReservaVip.contains(Cliente.entradaReservada);

                if(Cliente.asientoIdReservaVip.size()==2) {
                    System.out.println("Limite máximo de reservas alcanzado");

                }else if (Cliente.entradaReservada<=100 && Cliente.entradaReservada !=0 && Cliente.entradaReservada>=90) {
                    System.out.println();
                    System.out.println("Estamos validando la información...");

                    if (asientoDisponibleReservado==true || Cliente.asientoIdComprado.containsValue("Vip " + Cliente.entradaReservada)){
                        System.out.println("Este numero ya ha sido Reservado/Comprado anteriormente");
                    }else{
                        Cliente.asientoIdReservaVip.add(Cliente.entradaReservada);
                        System.out.println("Has reservado Exitosamente la entrada:");
                        System.out.println("VIP: " + Cliente.entradaReservada);
                        System.out.println("Puedes finalizar tu compra en la sección Comprar entrada!");
                        --Teatro.asientosDisponilesVip;
                    } //Punto de depuración

                }else{
                    System.out.println("Acción Invalida");
                }
                break;

            default:
                System.out.println("Accion Incorrecta");
        }
    }

    public static void comprar(){
        int opcionMenuCompra;
        Scanner scanner = new Scanner(System.in);

        String compraReservaUbicacion;
        int comprarReservaId;

        String compraDirectaUbicacion;
        int cantidadAsientosCompra;
        int numeroAsientoCompraDirecta;


        System.out.println(Cliente.nombre +"!");
        System.out.println("Te encuentras en el modulo de compras");
        System.out.println();


        System.out.println("Ingresa el número correspondiente a la accion que deseas realizar:");
        System.out.println();
        System.out.println("1. Comprar Asiento Reservado");
        System.out.println("2. Compra Directa de Asientos");
        System.out.println("3. Volver al Menú Principal");

        opcionMenuCompra= scanner.nextInt();


        switch (opcionMenuCompra){           //Punto de depuracion


            case 1:

                if(!Cliente.asientoIdReservaPalco.isEmpty()){
                    System.out.println("Posees estos asientos reservados:");
                    System.out.println("Palco: " + Cliente.asientoIdReservaPalco);
                }
                if(!Cliente.asientoIdReservaPlatea.isEmpty()) {
                    System.out.println("Posees estos asientos reservados:");
                    System.out.println("Platea: " + Cliente.asientoIdReservaPlatea);
                }
                if(!Cliente.asientoIdReservaVip.isEmpty()) {
                    System.out.println("Posees estos asientos reservados:");
                    System.out.println("Vip: " + Cliente.asientoIdReservaVip);
                }

                System.out.println("Ingresa la ubicacion Palco, Platea o Vip: "); //Punto de depuración
                compraReservaUbicacion = scanner.next().toLowerCase();

                switch (compraReservaUbicacion){

                    case "palco":           //Punto de depuracion

                        if (Cliente.asientoIdReservaPalco.isEmpty()){
                            System.out.println("No posees reservas asociadas a la ubicacion Palco");
                        }

                        System.out.println("Ingresa el asiento que deseas comprar");
                        comprarReservaId= scanner.nextInt();

                        if(Cliente.asientoIdReservaPalco.contains(comprarReservaId)){
                            System.out.println("Tu asiento ya no es una reserva");
                            System.out.println("Se ha cargado con exito el valor de $5000 a tu carrito de compras");


                            ++Cliente.numeroDeCompra;
                            Cliente.compra = Cliente.compra + 5000;

                            ++entradasVendidas;
                            Teatro.totalVendido = Teatro.totalVendido + 5000;

                            Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Palco " + comprarReservaId);
                            System.out.println("Compra N°" + Cliente.numeroDeCompra +" " + Cliente.asientoIdComprado);

                            if(Cliente.asientoIdReservaPalco.get(0).equals(comprarReservaId)){
                                Cliente.asientoIdReservaPalco.remove(0);
                            }else {
                                Cliente.asientoIdReservaPalco.remove(1);
                            }

                        } else if (!Cliente.asientoIdReservaPalco.contains(comprarReservaId)) {
                            System.out.println("No posees esta reserva asociadas a la ubicacion Palco");

                        }


                        break;

                    case "platea":          //Punto de depuracion
                        if (Cliente.asientoIdReservaPlatea.isEmpty()){
                            System.out.println("No posees reservas asociadas a la ubicacion Platea");
                        }

                        System.out.println("Ingresa el asiento que deseas comprar");
                        comprarReservaId= scanner.nextInt();
                        if(Cliente.asientoIdReservaPlatea.contains(comprarReservaId)){
                            System.out.println("Tu asiento ya no es una reserva");
                            System.out.println("Se ha cargado con exito el valor de $8000 a tu carrito de compras");


                            ++Cliente.numeroDeCompra;
                            Cliente.compra = Cliente.compra + 8000;

                            ++entradasVendidas;
                            Teatro.totalVendido = Teatro.totalVendido + 8000;

                            Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Platea " + comprarReservaId);
                            System.out.println(Cliente.asientoIdComprado);

                            if(Cliente.asientoIdReservaPlatea.get(0).equals(comprarReservaId)){
                                Cliente.asientoIdReservaPlatea.remove(0);
                            }else {
                                Cliente.asientoIdReservaPlatea.remove(1);
                            }


                        } else if (!Cliente.asientoIdReservaPlatea.contains(comprarReservaId)) {
                            System.out.println("No posees esta reserva asociadas a la ubicacion Palco");

                        }


                        break;

                    case "vip":         //Punto de depuracion
                        if (Cliente.asientoIdReservaVip.isEmpty()){
                            System.out.println("No posees reservas asociadas a la ubicacion Vip");
                        }

                        System.out.println("Ingresa el asiento que deseas comprar");
                        comprarReservaId= scanner.nextInt();
                        if(Cliente.asientoIdReservaVip.contains(comprarReservaId)){
                            System.out.println("Tu asiento ya no es una reserva");
                            System.out.println("Se ha cargado con exito el valor de $15000 a tu carrito de compras");

                            ++Cliente.numeroDeCompra;
                            Cliente.compra = Cliente.compra + 15000;

                            ++entradasVendidas;
                            Teatro.totalVendido = Teatro.totalVendido + 15000;

                            Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Vip " + comprarReservaId);
                            System.out.println(Cliente.asientoIdComprado);

                            if(Cliente.asientoIdReservaVip.get(0).equals(comprarReservaId)){
                                Cliente.asientoIdReservaVip.remove(0);
                            }else {
                                Cliente.asientoIdReservaVip.remove(1);
                            }


                        } else if (!Cliente.asientoIdReservaPalco.contains(comprarReservaId)) {
                            System.out.println("No posees esta reserva asociadas a la ubicacion Vip");

                        }


                        break;
                }


                break;
            case 2:
                System.out.println();
                System.out.println("Te encuentras en la seccion de compra directa");

                System.out.println("Ingresa la ubicacion Palco, Platea o Vip: ");
                compraDirectaUbicacion = scanner.next().toLowerCase();

                switch (compraDirectaUbicacion.toLowerCase()) {

                    case "palco":   //Punto de depuracion
                        System.out.println("El máximo de entradas por compra es de 4");
                        System.out.println("¿Cuantos asientos deseas comprar?");
                        cantidadAsientosCompra = scanner.nextInt();

                        if (cantidadAsientosCompra > 4) {
                            System.out.println("Excedes en maximo por compra ");

                        } else if (cantidadAsientosCompra < 5 && cantidadAsientosCompra != 0) {
                            System.out.println("Elige tus asientos");
                            System.out.println("Recuerda que tenemos asientos numerados hasta 60");


                            for (int i = 0; i < cantidadAsientosCompra; i++) {
                                System.out.println("Ingresa el numero del asiento que deseas comprar:");
                                numeroAsientoCompraDirecta = scanner.nextInt();

                                if (numeroAsientoCompraDirecta > 60 || numeroAsientoCompraDirecta == 0) {
                                    System.out.println("Accion invalida");
                                } else if (Cliente.asientoIdReservaPalco.contains(numeroAsientoCompraDirecta)) {
                                    System.out.println("Este número se encuentra reservado");

                                } else if (Cliente.asientoIdComprado.containsValue("Palco " + numeroAsientoCompraDirecta)) {
                                    System.out.println("Este asiento ya ha sido comprado");


                                } else if (!Cliente.asientoIdComprado.containsKey(numeroAsientoCompraDirecta)) {
                                    System.out.println("Has realizado con exito tu compra");
                                    System.out.println("Se han añadido 5000 a tu carrito de compras");
                                    System.out.println();

                                    ++Cliente.numeroDeCompra;
                                    Cliente.compra = Cliente.compra + 5000;

                                    ++entradasVendidas;
                                    Teatro.totalVendido = Teatro.totalVendido + 5000;
                                    --Teatro.asientosDisponiblesPalco;

                                    Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Palco " + numeroAsientoCompraDirecta);
                                    System.out.println("Compra N°" + Cliente.numeroDeCompra);
                                    System.out.println("Has realizado la compra de una entrada Palco N°" + numeroAsientoCompraDirecta);


                                } else {        //Punto de depuracion
                                    System.out.println("Acción incorrecta");
                                }
                            }
                        }
                        break;


                    case "platea":      //Punto de depuracion
                        System.out.println("El máximo de entradas por compra es de 4");
                        System.out.println("¿Cuantos asientos deseas comprar?");
                        cantidadAsientosCompra = scanner.nextInt();

                        if (cantidadAsientosCompra > 4) {
                            System.out.println("Excedes en maximo por compra ");

                        } else if (cantidadAsientosCompra < 5 && cantidadAsientosCompra != 0) {
                            System.out.println("Elige tus asientos");
                            System.out.println("Recuerda que tenemos asientos numerados desde 61 hasta 90");


                            for (int i = 0; i < cantidadAsientosCompra; i++) {
                                System.out.println("Ingresa el numero del asiento que deseas comprar:");
                                numeroAsientoCompraDirecta = scanner.nextInt();

                                if (numeroAsientoCompraDirecta < 60 || numeroAsientoCompraDirecta > 90) {
                                    System.out.println("Accion invalida");
                                } else if (Cliente.asientoIdReservaPlatea.contains(numeroAsientoCompraDirecta)) {
                                    System.out.println("Este número se encuentra reservado");

                                } else if (Cliente.asientoIdComprado.containsValue("Platea " + numeroAsientoCompraDirecta)) {
                                    System.out.println("Este asiento ya ha sido comprado");


                                } else if (!Cliente.asientoIdComprado.containsKey(numeroAsientoCompraDirecta)) {
                                    System.out.println("Has realizado con exito tu compra");
                                    System.out.println("Se han añadido 8000 a tu carrito de compras");
                                    System.out.println();

                                    ++Cliente.numeroDeCompra;
                                    Cliente.compra = Cliente.compra + 8000;
                                    --Teatro.asientosDisponilesPlatea;

                                    ++entradasVendidas;
                                    Teatro.totalVendido = Teatro.totalVendido + 8000;

                                    Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Platea " + numeroAsientoCompraDirecta);
                                    System.out.println("Has realizado la compra de una entrada Platea N°" + numeroAsientoCompraDirecta);


                                } else {        //Punto de depuracion
                                    System.out.println("Acción incorrecta");
                                }
                            }
                        }
                        break;


                    case "vip":     //Punto de depuracion
                        System.out.println("El máximo de entradas por compra es de 2");
                        System.out.println("¿Cuantos asientos deseas comprar?");
                        cantidadAsientosCompra = scanner.nextInt();

                        if (cantidadAsientosCompra > 2) {
                            System.out.println("Excedes en maximo por compra ");

                        } else if (cantidadAsientosCompra ==1 || cantidadAsientosCompra ==2) {
                            System.out.println("Elige tus asientos");
                            System.out.println("Recuerda que tenemos asientos numerados desde 91 hasta 100");


                            for (int i = 0; i < cantidadAsientosCompra; i++) {
                                System.out.println("Ingresa el numero del asiento que deseas comprar:");
                                numeroAsientoCompraDirecta = scanner.nextInt();

                                if (numeroAsientoCompraDirecta < 91 || numeroAsientoCompraDirecta > 100) {
                                    System.out.println("Accion invalida");
                                } else if (Cliente.asientoIdReservaVip.contains(numeroAsientoCompraDirecta)) {
                                    System.out.println("Este número se encuentra reservado");

                                } else if (Cliente.asientoIdComprado.containsValue("Vip " + numeroAsientoCompraDirecta)) {
                                    System.out.println("Este asiento ya ha sido comprado");


                                } else if (!Cliente.asientoIdComprado.containsKey(numeroAsientoCompraDirecta)) {
                                    System.out.println("Has realizado con exito tu compra");
                                    System.out.println("Se han añadido 15000 a tu carrito de compras");
                                    System.out.println();

                                    ++Cliente.numeroDeCompra;
                                    Cliente.compra = Cliente.compra + 15000;

                                    ++entradasVendidas;
                                    Teatro.totalVendido = Teatro.totalVendido + 15000;
                                    --Teatro.asientosDisponilesVip;

                                    Cliente.asientoIdComprado.put("Compra N° " + Cliente.numeroDeCompra, "Vip " + numeroAsientoCompraDirecta);
                                    System.out.println("Has realizado la compra de una entrada Vip N°" + numeroAsientoCompraDirecta);


                                } else {        //Punto de depuracion
                                    System.out.println("Acción incorrecta");
                                }
                            }
                                break;
                        }

                }



                break;

            case 3:
                Teatro.menuAtencion();
                break;
        }
    }

    public static void imprimirBoletos(){
        System.out.println("Estas son las entradas que has comprado:");     //Punto de depuracion
        System.out.println(Cliente.asientoIdComprado.values());
        System.out.println("El total de tu compra es de: " + Cliente.compra);       //Punto de depuracion



    }

    public static void modificarCompra(){
        int opcionModificarCompra;
        String ubicacionAnularAsiento;
        int anularNumeroCompra;
        String ubicacionModificarAsiento;
        int modificarNumeroCompra;
        int nuevoNumeroAsiento;
        Scanner scanner= new Scanner(System.in);


        System.out.println("En este modulo puedes modificar tu compra");
        System.out.println("Ingresa la accion que deseas realizar");
        System.out.println("1. Lista Asientos comprados");
        System.out.println("2. Anular Compra Asiento");
        System.out.println("3. Cambiar Asiento");
        System.out.println("4. Volver al Menú");
        opcionModificarCompra= scanner.nextInt();

        switch (opcionModificarCompra){

            case 1:
                Teatro.imprimirBoletos();

                break;

            case 2:              //Punto de depuracion
                System.out.println("Estas son las compras que has realizado:");
                for(int i=1; i<=Cliente.numeroDeCompra;i++){
                    System.out.println("Compra N°" + i);
                    System.out.println(Cliente.asientoIdComprado.get("Compra N° " + i));
                }
                System.out.println();

                System.out.println("Ingresa la unibicacion de la compra que deseas anular");
                System.out.println("\nPalco\nPlatea\nVip");
                ubicacionAnularAsiento= scanner.next();     //Punto de depuracion

                switch (ubicacionAnularAsiento.toLowerCase()) {

                    case "palco":       //Punto de depuracion
                        System.out.println("Elige el numero de COMPRA que deses anular");
                        anularNumeroCompra = scanner.nextInt();

                        if (anularNumeroCompra > Cliente.numeroDeCompra || anularNumeroCompra == 0) {
                            System.out.println("Número de compra Incorrecto");
                        } else if (Cliente.asientoIdComprado.containsKey("Compra N° " + anularNumeroCompra)) {
                            Cliente.asientoIdComprado.remove("Compra N° " + anularNumeroCompra);
                            Cliente.compra = Cliente.compra - 5000;
                            --Teatro.entradasVendidas;
                            ++Teatro.asientosDisponiblesPalco;      //Punto de depuracion
                        }
                        break;

                    case "platea":
                        System.out.println("Elige el numero de COMPRA que deses anular");
                        anularNumeroCompra = scanner.nextInt();

                        if (anularNumeroCompra > Cliente.numeroDeCompra || anularNumeroCompra == 0) {
                            System.out.println("Número de compra Incorrecto");
                        } else if (Cliente.asientoIdComprado.containsKey("Compra N° " + anularNumeroCompra)) {
                            Cliente.asientoIdComprado.remove("Compra N° " + anularNumeroCompra);
                            Cliente.compra = Cliente.compra - 8000;
                            --Teatro.entradasVendidas;
                            ++Teatro.asientosDisponilesPlatea;
                        }
                        break;

                    case "vip":
                        System.out.println("Elige el numero de COMPRA que deses anular");
                        anularNumeroCompra = scanner.nextInt();

                        if (anularNumeroCompra > Cliente.numeroDeCompra || anularNumeroCompra == 0) {
                            System.out.println("Número de compra Incorrecto");
                        } else if (Cliente.asientoIdComprado.containsKey("Compra N° " + anularNumeroCompra)) {
                            Cliente.asientoIdComprado.remove("Compra N° " + anularNumeroCompra);
                            Cliente.compra = Cliente.compra - 15000;
                            --Teatro.entradasVendidas;
                            ++Teatro.asientosDisponilesVip;
                            break;

                        }
                        break;

                }
            case 3:
                System.out.println("En esta seccion puedes modificar un asiento que has comprado");
                System.out.println("El nuevo asiento debe pertenecer a la misma Ubicacion (Palco, Platea, Vip)");

                System.out.println("Estas son las compras que has realizado:");
                for(int i=1; i<=Cliente.numeroDeCompra;i++){
                    System.out.println("Compra N°" + i);
                    System.out.println(Cliente.asientoIdComprado.get("Compra N° " + i));
                }
                System.out.println();
                System.out.println("Ingresa la Ubicacion del asiento que deseas modificar:");
                System.out.println("\nPalco\nPlatea\nVip");
                ubicacionModificarAsiento= scanner.next();


                switch (ubicacionModificarAsiento.toLowerCase()){           //Punto de depuracion

                    case "palco":
                        System.out.println("Ingresa el número de COMPRA que deseas modificar");
                        modificarNumeroCompra=scanner.nextInt();
                        System.out.println("Ingresa el NUEVO Asiento:");
                        System.out.println("Recuerda que en la Ubicacion Palco contamos con asientos numerados hasta 60");
                        nuevoNumeroAsiento= scanner.nextInt();
                        if (nuevoNumeroAsiento>60 || nuevoNumeroAsiento ==0) {
                            System.out.println("Número invalido");
                        }else {
                            Cliente.asientoIdComprado.replace("Compra N° " + modificarNumeroCompra, Cliente.asientoIdComprado.get("Compra N° "
                                    + modificarNumeroCompra), "Palco " + nuevoNumeroAsiento);       //Punto de depuracion
                        }


                        break;

                    case "platea":
                        System.out.println("Ingresa el número de COMPRA que deseas modificar");
                        modificarNumeroCompra=scanner.nextInt();
                        System.out.println("Ingresa el NUEVO Asiento:");
                        System.out.println("Recuerda que en la Ubicacion Platea contamos con asientos numerados entre 61 y 90");
                        nuevoNumeroAsiento= scanner.nextInt();
                        if (nuevoNumeroAsiento<60 || nuevoNumeroAsiento>90){
                            System.out.println("Número invalido");
                        }else{
                            Cliente.asientoIdComprado.replace("Compra N° " + modificarNumeroCompra, Cliente.asientoIdComprado.get("Compra N° "
                                    + modificarNumeroCompra), "Platea " + nuevoNumeroAsiento);
                        }

                        break;

                    case "vip":
                        System.out.println("Ingresa el número de COMPRA que deseas modificar");
                        modificarNumeroCompra=scanner.nextInt();
                        System.out.println("Ingresa el NUEVO Asiento:");
                        System.out.println("Recuerda que en la Ubicacion Vip contamos con asientos numerados entre 91 y 100");
                        nuevoNumeroAsiento= scanner.nextInt();
                        if (nuevoNumeroAsiento<91 || nuevoNumeroAsiento>100){
                            System.out.println("Número invalido");
                        }else{
                            Cliente.asientoIdComprado.replace("Compra N° " + modificarNumeroCompra, Cliente.asientoIdComprado.get("Compra N° "
                                    + modificarNumeroCompra), "Vip " + nuevoNumeroAsiento);
                        }

                        break;

                }

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
                    Teatro.reservarEntradas();
                    break;

                case 3:
                    Teatro.comprar();
                    break;

                case 4:
                    Teatro.modificarCompra();
                    break;

                case 5:
                    Teatro.imprimirBoletos();
                    break;

                case 6:
                    System.out.println("Hasta pronto " + Cliente.nombre + "!");
                    System.out.println("Gracias por venir a Teatro Moro!");
                    break;

                default:
                    System.out.println("Accion Incorrecta");

            }

        }while(Cliente.eleccionMenu<6);



    }
}