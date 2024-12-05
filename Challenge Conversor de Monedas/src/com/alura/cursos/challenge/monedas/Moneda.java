package com.alura.cursos.challenge.monedas;

public record Moneda(String base_code,
                     String target_code,
                     double convertion_rate) {
}
