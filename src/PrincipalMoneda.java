
import java.util.Scanner;

public class PrincipalMoneda {
    public static void main(String[] args) {

        Scanner divisa = new Scanner(System.in);
        ConsultaDivisasAPI consulta = new ConsultaDivisasAPI();

        System.out.println("Escriba el nombre de la divisa:");
        try {

            var tipomoneda = (divisa.nextLine());
            Moneda moneda = consulta.obtenerTasaDeCambio(tipomoneda, "USD"); //Ejemplo para visualizar el cambio de consulta
            System.out.println("Tasa de cambio para " + tipomoneda + " a USD" + moneda.conversion_rate());

        }catch (NumberFormatException e){
            System.out.println("Número de divisa no encontrado "+ e.getMessage());
        }catch (RuntimeException  e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
