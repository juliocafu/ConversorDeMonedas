package enums;

public enum Divisa {
    USD("Dólar USD"),
    ARS("Peso argentino ARS"),
    AWG("Florin arubeño AWG"),
    CLP("Peso chileno CLP"),
    EUR("Euro EUR"),
    MXN("Peso mexicano MXN"),
    KRW("Corea del sur Won KRW");

    private final String descripcion;

    Divisa(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método para mostrar todas las divisas disponibles
    public static void mostrarOpciones() {
        int i = 1;
        for (Divisa divisa : Divisa.values()) {
            System.out.println(i + ". " + divisa.getDescripcion());
            i++;
        }
        System.out.print("Seleccione una opción: ");
    }

    // Método para obtener una divisa a partir de una opción numérica
    public static Divisa obtenerDivisaPorIndex(int indice) {
        if (indice < 1 || indice > Divisa.values().length) {
            throw new IllegalArgumentException("Índice fuera de rango. Rango permitido entre 1 y " + Divisa.values().length);
        }
        return Divisa.values()[indice - 1];
    }
}
