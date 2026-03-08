package com.alura.conversor.principal;

import com.alura.conversor.consultas.ConsultaMoneda;
import com.alura.conversor.consultas.GeneradorDeArchivo;
import com.alura.conversor.modelos.Moneda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        List<String> historial = new ArrayList<>();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("******************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar -> Peso argentino\n" +
                    "2) Peso argentino -> Dólar\n" +
                    "3) Dólar -> Real brasileño\n" +
                    "4) Real brasileño -> Dólar\n" +
                    "5) Dólar -> Peso colombiano\n" +
                    "6) Peso colombiano -> Dólar\n" +
                    "7) Salir");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 7) break;

                System.out.print("Ingrese el valor que desea convertir: ");
                double valor = Double.parseDouble(lectura.nextLine());

                String base = "", destino = "";
                switch (opcion) {
                    case 1 -> { base = "USD"; destino = "ARS"; }
                    case 2 -> { base = "ARS"; destino = "USD"; }
                    case 3 -> { base = "USD"; destino = "BRL"; }
                    case 4 -> { base = "BRL"; destino = "USD"; }
                    case 5 -> { base = "USD"; destino = "COP"; }
                    case 6 -> { base = "COP"; destino = "USD"; }
                    default -> System.out.println("Opción no válida.");
                }

                if (!base.isEmpty()) {
                    Moneda moneda = consulta.buscarMoneda(base);
                    double tasa = moneda.conversion_rates().get(destino);
                    double resultado = valor * tasa;

                    String mensaje = String.format("El valor %.2f [%s] corresponde a =>>> %.2f [%s]",
                            valor, base, resultado, destino);

                    System.out.println(mensaje);
                    historial.add(mensaje);
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error. Intente de nuevo.");
            }
        }

        try {
            if (!historial.isEmpty()) {
                generador.guardarJson(historial);
                System.out.println("Historial guardado en 'consultas.json'. ¡Adiós!");
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo.");
        }
    }
}