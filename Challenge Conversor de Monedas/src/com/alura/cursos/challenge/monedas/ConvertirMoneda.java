package com.alura.cursos.challenge.monedas;

import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura) {
        // Verificar que la instancia de 'consulta' no sea nula
        if (consulta == null) {
            System.out.println("Error: la consulta de moneda no se ha inicializado.");
            return; // Salir del método si 'consulta' es nulo
        }

        // Usar la instancia de ConsultarMoneda para obtener la tasa de cambio
        Moneda moneda = consulta.buscarMoneda(monedaBase, monedaTarget);

        if (moneda != null) {
            System.out.println("La tasa de cambio de " + monedaBase + " a " + monedaTarget + " es: " + moneda.convertion_rate());
            System.out.println("¿Cuánto desea convertir?");
            double cantidad = lectura.nextDouble();
            double resultado = cantidad * moneda.convertion_rate();
            System.out.println("Resultado: " + cantidad + " " + monedaBase + " = " + resultado + " " + monedaTarget);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio.");
        }
    }
}

