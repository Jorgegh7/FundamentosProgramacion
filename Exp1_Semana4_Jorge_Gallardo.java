import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String continuarCompra = "";

        do {
            System.out.println();
            System.out.println("Bienvenido al Teatro Moro!");
            System.out.println("Escribe la accion que deseas realizar:");
            System.out.println();

            String[] menuPrincipal = {"Comprar Entrada", "Salir"};

            for (int i = 0; i < menuPrincipal.length; i++) {
                System.out.println((menuPrincipal[i]));
            }
            Scanner scanner = new Scanner(System.in);
            String accionMenu = scanner.nextLine();


            if (accionMenu.toLowerCase().equals("salir")) {
                System.out.println("Hasta pronto");
                System.out.println("Gracias por venir al Teatro Moro");


            } else if (accionMenu.toLowerCase().equals("comprar entrada")) {

                String[] ubicacionTeatro = {"Palco", "Platea Alta", "Platea Baja"};

                System.out.println();
                System.out.println("Ingresa la ubicacion de tu compra:");
                System.out.println();
                for (int j = 0; j < ubicacionTeatro.length; j++) {
                    System.out.println(ubicacionTeatro[j]);
                }
                String opcionUbicacionUsuario = scanner.nextLine();
                int palco = 6000;
                int plateaAlta = 8000;
                int plateaBaja = 10000;


                if (opcionUbicacionUsuario.equalsIgnoreCase("palco")) {
                    System.out.println();
                    System.out.println("Escogiste Palco este tiene un valor de: " + palco);
                    System.out.println("Ahora veamos si podemos aplicar algun tipo de descuento");

                    System.out.println("Ingresa tu edad");
                    int edadUsuario = scanner.nextInt();

                    if (edadUsuario <= 18) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + palco);
                        System.out.println("Se aplica el descuento ESTUDIANTE correspondiente a un 10% DCTO");
                        System.out.println("PRECIO FINAL: " + palco * 0.9);
                        System.out.println("******************");
                        System.out.println();


                    } else if (edadUsuario > 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + palco);
                        System.out.println("Se aplica el descuento TERCERA EDAD correspondiente a un 10% DCTO");
                        System.out.println("PRECIO FINAL: " + palco * 0.85);
                        System.out.println("******************");
                        System.out.println();


                    } else if (edadUsuario > 18 && edadUsuario < 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + palco);
                        System.out.println("NO TIENES DESCUENTO");
                        System.out.println("PRECIO FINAL: " + palco);
                        System.out.println("******************");
                        System.out.println();


                        continuarCompra = scanner.next().toLowerCase();
                    } else {
                        System.out.println("Valor ingresado invalido");
                        System.out.println();
                    }



                    System.out.println("¿Deseas seguir comprando?");
                    System.out.println("Escribe Si o No");
                    continuarCompra = scanner.next().toLowerCase();


                } else if (opcionUbicacionUsuario.equalsIgnoreCase("platea alta")) {
                    System.out.println();
                    System.out.println("Escogiste Platea Alta este tienen un valor de: " + plateaAlta);

                    System.out.println("Ingresa tu edad");
                    int edadUsuario = scanner.nextInt();

                    if (edadUsuario <= 18) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + plateaAlta);
                        System.out.println("Se aplica el descuento ESTUDIANTE correspondiente a un 10% DCTO");
                        System.out.println("PRECIO FINAL: " + plateaAlta * 0.9);
                        System.out.println("******************");
                        System.out.println();


                    } else if (edadUsuario > 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + plateaAlta);
                        System.out.println("Se aplica el descuento TERCERA EDAD correspondiente a un 15% DCTO");
                        System.out.println("PRECIO FINAL: " + plateaAlta * 0.85);
                        System.out.println("******************");
                        System.out.println();


                    } else if (edadUsuario > 18 && edadUsuario < 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO :" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION " + opcionUbicacionUsuario.toUpperCase() + ": " + plateaAlta);
                        System.out.println("NO TIENES DESCUENTO");
                        System.out.println("PRECIO FINAL: " + plateaAlta);
                        System.out.println("******************");
                        System.out.println();


                    } else {
                        System.out.println("Valor ingresado invalido");
                        System.out.println();
                    }

                    System.out.println("¿Deseas seguir comprando?");
                    System.out.println("Escribe Si o No");
                    continuarCompra = scanner.next().toLowerCase();


                } else if (opcionUbicacionUsuario.equalsIgnoreCase("platea baja")) {
                    System.out.println();
                    System.out.println("Escogiste Platea Baja este tiene un valor de: " + plateaBaja);

                    System.out.println("Ingresa tu edad");
                    int edadUsuario = scanner.nextInt();

                    if (edadUsuario <= 18) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + plateaBaja);
                        System.out.println("Se aplica el descuento ESTUDIANTE correspondiente a un 10% DCTO");
                        System.out.println("PRECIO FINAL: " + plateaBaja * 0.9);
                        System.out.println("******************");
                        System.out.println();



                    } else if (edadUsuario > 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION" + opcionUbicacionUsuario.toUpperCase() + ": " + plateaBaja);
                        System.out.println("Se aplica el descuento TERCERA EDAD correspondiente a un 15% DCTO");
                        System.out.println("PRECIO FINAL: " + plateaBaja * 0.85);
                        System.out.println("******************");
                        System.out.println();




                    } else if (edadUsuario > 18 && edadUsuario < 60) {
                        System.out.println();
                        System.out.println("******************");
                        System.out.println("UBICACION ASIENTO:" + opcionUbicacionUsuario.toUpperCase());
                        System.out.println("PRECIO BASE UBICACION " + opcionUbicacionUsuario.toUpperCase() + ": " + plateaBaja);
                        System.out.println("NO TIENES DESCUENTO");
                        System.out.println("PRECIO FINAL: " + plateaBaja);
                        System.out.println("******************");
                        System.out.println();



                    } else {
                        System.out.println("Valor ingresado invalido");
                        System.out.println();
                    }
                    System.out.println("¿Deseas seguir comprando?");
                    System.out.println("Escribe Si o No");
                    continuarCompra = scanner.next().toLowerCase();



                } else {
                    System.out.println("Comando invalido");
                    System.out.println();

                    System.out.println("¿Deseas seguir comprando?");
                    System.out.println("Escribe Si o No");
                    continuarCompra = scanner.next().toLowerCase();
                }
            } else {
                System.out.println("Accion invalida");
                System.out.println();

                System.out.println("¿Deseas seguir comprando?");
                System.out.println("Escribe Si o No");
                continuarCompra = scanner.next().toLowerCase();
            }


        } while (continuarCompra.equals("si") && !continuarCompra.equals("no"));

    }

}