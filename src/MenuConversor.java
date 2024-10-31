import enums.Divisa;
import java.util.Scanner;

public class MenuConversor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("**********************************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda:");

        while (continuar) {
            // Moneda base
            System.out.println();
            System.out.println("Seleccione la moneda base:");
            Divisa.mostrarOpciones();
            int seleccionBase = scanner.nextInt();
            Divisa monedaBase = Divisa.obtenerDivisaPorIndex(seleccionBase);

            // Moneda destino
            System.out.println();
            System.out.println("Seleccione la moneda destino:");
            Divisa.mostrarOpciones();
            int seleccionDestino = scanner.nextInt();
            Divisa monedaDestino = Divisa.obtenerDivisaPorIndex(seleccionDestino);

            // Monto a convertir
            System.out.println();
            System.out.print("Ingrese el monto a convertir de " + monedaBase + " a " + monedaDestino + ": ");
            double monto = scanner.nextDouble();

            // Realizar conversión
            Moneda tasaCambio = ConsultaDivisasAPI.obtenerTasaDeCambio(monedaBase.name(), monedaDestino.name());

            if (tasaCambio != null) {
                double montoConvertido = monto * tasaCambio.conversion_rate();
                System.out.println("\nEl monto convertido es: " + montoConvertido + " " + monedaDestino);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio.");
            }

            // Preguntar si desea continuar
            System.out.println("\n¿Desea realizar otra conversión? (S/N): ");
            char respuesta = scanner.next().toUpperCase().charAt(0);
            if (respuesta != 'S') {
                continuar = false;
                System.out.println("Gracias por utilizar el conversor de monedas.");
            }
        }
        System.out.println("**********************************************************************");
    }
}
