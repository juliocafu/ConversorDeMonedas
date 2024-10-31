<h1 align="center"> Conversor de Monedas </h1>

## Descripción
Este proyecto es un **Conversor de Monedas** en Java, que permite convertir entre varias divisas utilizando tasas de cambio en tiempo real obtenidas de una API externa. La aplicación es interactiva y permite al usuario seleccionar las divisas base y destino, ingresar un monto a convertir, y ver el resultado de la conversión en la divisa seleccionada.

## Características

- Conversión entre divisas como USD, ARS, AWG, CLP, EUR, MXN y KRW.
- Menú interactivo con selección de divisas y opción de repetir conversiones.
- Integración con la API [ExchangeRate API](https://www.exchangerate-api.com) para obtener tasas de cambio actualizadas.
  
## Requisitos

- **Java 11** o superior
- **Gson**: Biblioteca para parsear JSON. Se puede añadir al proyecto utilizando Maven o añadiendo el `.jar` de Gson en la ruta de `lib`.

## Instalación

1. Clona este repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas.git

Importa el proyecto en tu entorno de desarrollo de Java.

Agrega la biblioteca Gson para manejo de JSON.

## Uso
Ejecuta la clase principal MenuConversor para iniciar la aplicación:

## java
Copiar código
public class MenuConversor {

    public static void main(String[] args) {
        System.out.println("**********************************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda:");
        
        // Código principal para iniciar la aplicación
    }
}
Ejemplo de Ejecución
plaintext
Copiar código
**********************************************************************
Sea bienvenido/a al Conversor de Moneda: 

1. Dólar USD 
2. Peso argentino ARS 
3. Florin arubeño AWG 
4. Peso chileno CLP 
5. Euro EUR 
6. Peso mexicano MXN 
7. Corea del sur Won KRW 

Seleccione una opción: 1

Seleccione la moneda destino:
1. Dólar USD 
2. Peso argentino ARS 
3. Florin arubeño AWG 
4. Peso chileno CLP 
5. Euro EUR 
6. Peso mexicano MXN 
7. Corea del sur Won KRW 

Seleccione una opción: 5

Ingrese el monto a convertir de USD a EUR: 100

El monto convertido es: 85.0 EUR

¿Desea realizar otra conversión? (S/N): N
Gracias por utilizar el conversor de monedas.
**********************************************************************
## Arquitectura
MenuConversor.java: Clase principal que contiene el menú interactivo.
ConsultaDivisasAPI.java: Clase para manejar la consulta a la API y obtener las tasas de cambio.
Divisa.java: Enum que contiene las divisas soportadas con sus nombres descriptivos.
Moneda.java: Record que almacena la tasa de conversión de la moneda base y de la moneda destino.
## Créditos
Este proyecto fue desarrollado para propósitos educativos y utiliza ExchangeRate API para obtener las tasas de cambio actuales.
