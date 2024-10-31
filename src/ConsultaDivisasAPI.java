import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaDivisasAPI {

    private static final String API_KEY = "9831681d51d53c29a5238937";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    static class RespuestaAPI {
        String base_code;
        Map<String, Double> conversion_rates; // En esta parte se van a almacenar las tasas de cambio de diferentes monedas.
    }

    public static Moneda obtenerTasaDeCambio(String monedaBase, String monedaDestino) {
        try {
            String urlStr = BASE_URL + monedaBase;
            URI url = new URI(urlStr);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RespuestaAPI respuestaAPI = new Gson().fromJson(response.body(), RespuestaAPI.class);
            Double tasaConversion = respuestaAPI.conversion_rates.get(monedaDestino);
            if (tasaConversion != null) {
                return new Moneda(respuestaAPI.base_code, tasaConversion);
            } else {
                throw new RuntimeException("Tasa de cambio no encontrada para " + monedaDestino);
            }
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda. " + e.getMessage());
        }

//    public Moneda obtenerMoneda(double numMoneda){
//        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9831681d51d53c29a5238937/latest/"+numMoneda);
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(direccion)
//                .build();
//
//        HttpResponse<String> response = null;
//        try {
//            response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//            return new Gson().fromJson(response.body(), Moneda.class);
//        } catch (Exception e) {
//            throw new RuntimeException("No encontré esa moneda.");
//        }
//    }
    }
}
