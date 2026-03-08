package com.alura.conversor.consultas;

import com.alura.conversor.modelos.Moneda;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarMoneda(String monedaBase) {
        String apiKey = "9b6dfa305bae3aefc46aa771";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: No se pudo obtener la tasa de cambio.");
        }
    }
}