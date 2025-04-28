import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    static String nombreCliente;
    static int edadCliente;
    static int opcionMenuCliente;
}

class Boleta{
    int numeroCompra;
    String ubicacionAsiento;
    int numeroAsiento;
    int cantidadAsientos;
    double valorAsiento;
    double descuento;
    double totalCompra;
    String tipoDescuento;

    public Boleta(){}

    public Boleta(int numeroCompra, String ubicacionAsiento, int numeroAsiento, double valorAsiento,
                  double descuento, double totalCompra, String tipoDescuento) {

        this.numeroCompra = numeroCompra;
        this.ubicacionAsiento = ubicacionAsiento;
        this.numeroAsiento = numeroAsiento;
        this.valorAsiento = valorAsiento;
        this.descuento = descuento;
        this.totalCompra = totalCompra;
        this.tipoDescuento = tipoDescuento;
    }

    public int getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public String getUbicacionAsiento() {
        return ubicacionAsiento;
    }

    public void setUbicacionAsiento(String ubicacionAsiento) {
        this.ubicacionAsiento = ubicacionAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getValorAsiento() {
        return valorAsiento;
    }

    public void setValorAsiento(double valorAsiento) {
        this.valorAsiento = valorAsiento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    @Override
    public String toString() {
        return  "----------------------------" +'\n' +
                "Cliente: " + Usuario.nombreCliente + ", " + Usuario.edadCliente + " años"+ '\n' +
                "Boleta Numero: " + getNumeroCompra() + '\n' +
                "Ubicacion: " + getUbicacionAsiento() + '\n' +
                "Asiento: " + getNumeroAsiento() + '\n' +
                "Valor Asiento: " + getValorAsiento() + '\n' +
                "Descuento: " + getTipoDescuento() + '\n' +
                "Valor Final: " + getTotalCompra() + '\n' +
                "-----------------------------";

    }



}

class Teatro {

    static ArrayList<Boleta> comprasEntradas = new ArrayList<>();

    //Valores entradas
    static double entradaBalcon = 5000;
    static double entradaPlatea = 8000;
    static double entradaVip = 15000;

    static double descuento;

    //descuentos
    static String descuentoEstudiante = "10%";
    static String descuentoAdultoMayor = "15%";
    static String descuentoNoAplicado = "No posees descuento";

    static double sumaValorBoletas=0;


    public static void bienvenida(Boleta boleta) {


        System.out.println();
        System.out.println("Bienvenido a Teatro Moro!");
        System.out.println("Para una mejor atención ingresa tu nombre:");

        Scanner scanner = new Scanner(System.in);
        Usuario.nombreCliente = scanner.next();
        System.out.println();

        System.out.println(Usuario.nombreCliente + "!");
        System.out.println("Por favor ingresa tu edad para corroborar si tienes algun tipo de descuento:");
        Usuario.edadCliente= scanner.nextInt();

        if (Usuario.edadCliente < 18 && Usuario.edadCliente != 0) {
            System.out.println("Eres MENOR de Edad!");
            System.out.println("Aplicas para un descuento del 10% sobre el valor de tu compra");
            Teatro.descuento= 0.9;
            boleta.setTipoDescuento(Teatro.descuentoEstudiante);
        } else if (Usuario.edadCliente >= 60) {
            System.out.println("Eres TERCERA Edad!");
            System.out.println("Aplicas para un descuento del 15% sobre el valor de tu compra");
            Teatro.descuento= 0.85;
            boleta.setTipoDescuento(Teatro.descuentoAdultoMayor);

        }else{
            System.out.println("NO aplicas a descuento por edad");
            Teatro.descuento= 1;
        }

    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("--------------------");
        System.out.println("Menú Teatro Moro!");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("1. Informacion General Teatro");
        System.out.println("2. Venta de Entradas");
        System.out.println("3. Imprimir Ultima Boleta");
        System.out.println("4. Carrito de Compras");
        System.out.println("5. Salir");
        System.out.println("--------------------");
        System.out.println();

        System.out.println("Ingresa tu opcion:");
        Usuario.opcionMenuCliente= scanner.nextInt();
    }

    public static void informacionGeneralTeatro(){
        System.out.println();
        System.out.println("*Informacion General de Teatro Moro*");
        System.out.println("-------------------------------------");
        System.out.println();

        System.out.println("Capacidad General Teatro: 100 Asientos");
        System.out.println();
        System.out.println("Tipo de Ubicacion: \nBalcon\nPlatea\nVip");
        System.out.println();
        System.out.println("Valor Asientos");
        System.out.println("\nBalcon: 5000\nPlatea: 8000\nVip: 15000");
        System.out.println();
        System.out.println("Descuentos");
        System.out.println("Descuentos aplicados a Estudiantes: 10% Sobre el Total de tu Compra");
        System.out.println("Descuentos aplicados a Adulto Mayor: 15% Sobre el Total de tu Compra");
    }

    public static void ventaEntradas(Boleta boleta){
        System.out.println();
        System.out.println("Escribe la Ubicacion de tu Compra");
        System.out.println("Balcon\nPlatea\nVip");
        Scanner scanner = new Scanner(System.in);
        boleta.setUbicacionAsiento(scanner.next().toLowerCase());

        switch (boleta.getUbicacionAsiento()){

            case "balcon":
                System.out.println("En la Ubicacion Balcon poseemos asientos numerados hasta 40");
                System.out.println("Elige el numero de asiento");
                boleta.setNumeroAsiento(scanner.nextInt());

                if(boleta.getNumeroAsiento()<=40 && boleta.getNumeroAsiento() !=0){
                    System.out.println("Asiento Seleccionado con exito");
                    System.out.println("Has agregado a tu carrito un asiento tipo " + boleta.getUbicacionAsiento() + " " +
                            boleta.getNumeroAsiento());
                    boleta.setNumeroCompra(++boleta.numeroCompra);
                    boleta.setValorAsiento(Teatro.entradaBalcon);
                    boleta.setTotalCompra(Teatro.entradaBalcon*Teatro.descuento);
                    comprasEntradas.add(boleta);
                }else{
                    System.out.println("Acción invalida o número Fuera de Rango");
                }


                break;

            case "platea":
                System.out.println("En la Ubicacion Platea poseemos asientos numerados desde 41 hasta 80");
                System.out.println("Elige el numero de asiento");
                boleta.setNumeroAsiento(scanner.nextInt());

                if(boleta.getNumeroAsiento()<=40 && boleta.getNumeroAsiento() >80){
                    System.out.println("Asiento Seleccionado fuera de rango");
                }else{
                    System.out.println("Has agregado a tu carrito un asiento tipo " + boleta.getUbicacionAsiento() + " " +
                            boleta.getNumeroAsiento());
                    boleta.setNumeroCompra(++boleta.numeroCompra);
                    boleta.setValorAsiento(Teatro.entradaPlatea);
                    boleta.setTotalCompra(Teatro.entradaPlatea*Teatro.descuento);
                    comprasEntradas.add(boleta);
                }
                break;

            case "vip":
                System.out.println("En la Ubicacion Vip poseemos asientos numerados desde 81 hasta 100");
                System.out.println("Elige el numero de asiento");
                boleta.setNumeroAsiento(scanner.nextInt());

                if(boleta.getNumeroAsiento()<=80 && boleta.getNumeroAsiento() >100){
                    System.out.println("Asiento Seleccionado fuera de rango");
                }else{
                    System.out.println("Has agregado a tu carrito un asiento tipo " + boleta.getUbicacionAsiento() + " " +
                            boleta.getNumeroAsiento());
                    boleta.setNumeroCompra(++boleta.numeroCompra);
                    boleta.setValorAsiento(Teatro.entradaVip);
                    boleta.setTotalCompra(Teatro.entradaVip*Teatro.descuento);
                    comprasEntradas.add(boleta);
                }
                break;

        }




    }

    public static void Boleta(ArrayList<Boleta> boleta){
        boleta = comprasEntradas;
        for (int i = 0; i < boleta.size(); i++) {
            System.out.println("--------------------------");
            System.out.println("        Teatro Moro       ");
            System.out.println("--------------------------");
            System.out.println("Ubicacion: " + boleta.get(i).getUbicacionAsiento());
            System.out.println("Numero de Asiento " + boleta.get(i).getNumeroAsiento() );
            System.out.println("Costo Base: $" + boleta.get(i).getValorAsiento());
            System.out.println("Descuento Aplicado: " + boleta.get(i).getTipoDescuento());
            System.out.println("Costo Final: " + boleta.get(i).getTotalCompra());
            System.out.println("--------------------------");
            System.out.println("Gracias por venir a Teatro Moro");
        }
    }

    public static void ImpresionBoletas(ArrayList<Boleta> boleta){
        boleta = comprasEntradas;
        for (int i = 0; i < boleta.size(); i++) {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("Numero Compra: " + boleta.get(i).getNumeroCompra());
            System.out.println("Ubicacion: " + boleta.get(i).getUbicacionAsiento());
            System.out.println("Numero de Asiento " + boleta.get(i).getNumeroAsiento() );
            System.out.println("Costo Base: $" + boleta.get(i).getValorAsiento());
            System.out.println("Descuento Aplicado: " + boleta.get(i).getTipoDescuento());
            System.out.println("Costo Final: " + boleta.get(i).getTotalCompra());
            System.out.println("--------------------------");
            System.out.println();
        }
    }




}

public class Main {

    public static void main(String[] args) {
        Boleta boleta = new Boleta();
        ArrayList<Integer> numerosAsientosComprados= new ArrayList<>();
        ArrayList<Boleta> carrito = new ArrayList<>();


        System.out.println();
        System.out.println("Bienvenido a Teatro Moro!");
        System.out.println("Para una mejor atención ingresa tu nombre:");

        Scanner scanner = new Scanner(System.in);
        Usuario.nombreCliente = scanner.next();
        System.out.println();

        System.out.println(Usuario.nombreCliente + "!");
        System.out.println("Por favor ingresa tu edad para corroborar si tienes algun tipo de descuento:");
        Usuario.edadCliente= scanner.nextInt();

        if (Usuario.edadCliente < 18 && Usuario.edadCliente != 0) {
            System.out.println("Eres MENOR de Edad!");
            System.out.println("Aplicas para un descuento del 10% sobre el valor de tu compra");
            Teatro.descuento= 0.9;
            boleta.setTipoDescuento(Teatro.descuentoEstudiante);
        } else if (Usuario.edadCliente >= 60) {
            System.out.println("Eres TERCERA Edad!");
            System.out.println("Aplicas para un descuento del 15% sobre el valor de tu compra");
            Teatro.descuento= 0.85;
            boleta.setTipoDescuento(Teatro.descuentoAdultoMayor);

        }else{
            System.out.println("NO aplicas a descuento por edad");
            Teatro.descuento= 1;
            boleta.setTipoDescuento(Teatro.descuentoNoAplicado);
        }

        do {
            Teatro.menu();
            switch (Usuario.opcionMenuCliente) {
                case 1:
                    Teatro.informacionGeneralTeatro();
                    break;

                case 2:
                    Boleta nuevaBoleta = new Boleta();

                    System.out.println();
                    System.out.println("Escribe la Ubicacion de tu Compra");
                    System.out.println("Balcon\nPlatea\nVip");
                    scanner = new Scanner(System.in);
                    nuevaBoleta.setUbicacionAsiento(scanner.next().toLowerCase());

                    switch (nuevaBoleta.getUbicacionAsiento()) {

                        case "balcon":
                            System.out.println("En la Ubicacion Balcon poseemos asientos numerados hasta 40");
                            System.out.println("Elige el numero de asiento");
                            nuevaBoleta.setNumeroAsiento(scanner.nextInt());

                            if (numerosAsientosComprados.contains(nuevaBoleta.getNumeroAsiento())){
                                System.out.println("Este numero ya ha sido seleccionado");

                            } else if (nuevaBoleta.getNumeroAsiento() <= 40 && nuevaBoleta.getNumeroAsiento() != 0) {
                                System.out.println("Asiento Seleccionado con exito");
                                System.out.println("Has agregado a tu carrito un asiento tipo " + nuevaBoleta.getUbicacionAsiento() + " " +
                                        nuevaBoleta.getNumeroAsiento());
                                nuevaBoleta.setNumeroCompra(++boleta.numeroCompra);
                                nuevaBoleta.setValorAsiento(Teatro.entradaBalcon);
                                nuevaBoleta.setTotalCompra(Teatro.entradaBalcon * Teatro.descuento);
                                numerosAsientosComprados.add(nuevaBoleta.numeroAsiento);
                                nuevaBoleta.setTipoDescuento(boleta.tipoDescuento);
                                Teatro.sumaValorBoletas= Teatro.sumaValorBoletas + nuevaBoleta.getTotalCompra();
                                carrito.add(nuevaBoleta);

                            } else {
                                System.out.println("Acción invalida o número Fuera de Rango");
                            }


                            break;

                        case "platea":
                            System.out.println("En la Ubicacion Platea poseemos asientos numerados desde 41 hasta 80");
                            System.out.println("Elige el numero de asiento");
                            nuevaBoleta.setNumeroAsiento(scanner.nextInt());

                            if (numerosAsientosComprados.contains(nuevaBoleta.getNumeroAsiento())) {
                                System.out.println("Este numero ya ha sido seleccionado");

                            } else if (nuevaBoleta.getNumeroAsiento() <= 40 && nuevaBoleta.getNumeroAsiento() > 80) {
                                System.out.println("Asiento Seleccionado fuera de rango");
                            } else {
                                System.out.println("Has agregado a tu carrito un asiento tipo " + nuevaBoleta.getUbicacionAsiento() + " " +
                                        nuevaBoleta.getNumeroAsiento());
                                nuevaBoleta.setNumeroCompra(++boleta.numeroCompra);
                                nuevaBoleta.setValorAsiento(Teatro.entradaPlatea);
                                nuevaBoleta.setTotalCompra(Teatro.entradaPlatea * Teatro.descuento);
                                numerosAsientosComprados.add(nuevaBoleta.numeroAsiento);
                                nuevaBoleta.setTipoDescuento(boleta.tipoDescuento);
                                Teatro.sumaValorBoletas= Teatro.sumaValorBoletas + nuevaBoleta.getTotalCompra();
                                carrito.add(nuevaBoleta);

                            }
                            break;

                        case "vip":
                            System.out.println("En la Ubicacion Vip poseemos asientos numerados desde 81 hasta 100");
                            System.out.println("Elige el numero de asiento");
                            nuevaBoleta.setNumeroAsiento(scanner.nextInt());

                            if (numerosAsientosComprados.contains(nuevaBoleta.getNumeroAsiento())) {
                                System.out.println("Este numero ya ha sido seleccionado");

                            } else if (nuevaBoleta.getNumeroAsiento() <= 80 && nuevaBoleta.getNumeroAsiento() > 100) {
                                System.out.println("Asiento Seleccionado fuera de rango");
                            } else {
                                System.out.println("Has agregado a tu carrito un asiento tipo " + nuevaBoleta.getUbicacionAsiento() + " " +
                                        nuevaBoleta.getNumeroAsiento());
                                nuevaBoleta.setNumeroCompra(++boleta.numeroCompra);
                                nuevaBoleta.setValorAsiento(Teatro.entradaVip);
                                nuevaBoleta.setTotalCompra(Teatro.entradaVip * Teatro.descuento);
                                numerosAsientosComprados.add(nuevaBoleta.numeroAsiento);
                                nuevaBoleta.setTipoDescuento(boleta.tipoDescuento);
                                Teatro.sumaValorBoletas= Teatro.sumaValorBoletas + nuevaBoleta.getTotalCompra();
                                carrito.add(nuevaBoleta);
                            }
                            break;

                    }
                    break;

                case 3:

                        System.out.println("--------------------------");
                        System.out.println("        Teatro Moro       ");
                        System.out.println("--------------------------");
                        System.out.println("Ubicacion: " + carrito.getLast().getUbicacionAsiento());
                        System.out.println("Numero de Asiento " + carrito.getLast().getNumeroAsiento());
                        System.out.println("Costo Base: $" + carrito.getLast().getValorAsiento());
                        System.out.println("Descuento Aplicado: " + carrito.getLast().getTipoDescuento());
                        System.out.println("Costo Final: " + carrito.getLast().getTotalCompra());
                        System.out.println("--------------------------");
                        System.out.println("Gracias por venir a Teatro Moro");

                    break;

                case 4:
                    for (int i = 0; i < carrito.size(); i++) {
                        System.out.println(carrito.get(i));
                    }
                    System.out.println("El valor total de tu compra es: $" + Teatro.sumaValorBoletas);
                    break;
                case 5:
                    System.out.println("Gracias por venir a Teatro Moro");
                    System.out.println("Hasta la proxima!");
                    break;
            }
        } while (Usuario.opcionMenuCliente< 5);


    }

}

