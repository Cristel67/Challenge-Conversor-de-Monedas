package com.alura.cursos.challenge.monedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultarMoneda {

    public Moneda buscarMoneda(String monedaBase, String monedaTarget) {
        // URL correcta de la API, pasando los códigos de las monedas base y destino
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/db7022e2ef6a62d62ff83872/pair/" + monedaBase + "/" + monedaTarget);

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Realizar la solicitud HTTP
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Mostrar la respuesta JSON para verificar su estructura
            System.out.println("Respuesta de la API: " + response.body());

            // Deserializar la respuesta JSON utilizando Gson
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

            // Verificar si la solicitud fue exitosa
            if ("success".equals(apiResponse.result)) {
                // Retornar la nueva instancia de Moneda con la tasa de conversión
                double conversionRate = apiResponse.conversion_rate;
                return new Moneda(monedaBase, monedaTarget, conversionRate);
            } else {
                throw new RuntimeException("Error al obtener la tasa de conversión.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo obtener la tasa de conversión de " + monedaBase + " a " + monedaTarget);
        }
    }

    // Clase interna para manejar la respuesta de la API
    private class ApiResponse {
        String result;  // "success" o "error"
        double conversion_rate;  // Tasa de conversión
        String base_code;  // Código de la moneda base
        String target_code;  // Código de la moneda destino
    }
}
