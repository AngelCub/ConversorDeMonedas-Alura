package com.alura.conversor.consultas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {
    public void guardarJson(List<String> historial) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();

        try (FileWriter escritura = new FileWriter("consultas.json")) {
            escritura.write(gson.toJson(historial));
        }
    }
}