package com.piscis.veterinaria.dto;

import java.math.BigInteger;

public record PostDuenoDTO(
        BigInteger dni,
        String nombre,
        String apellido,
        BigInteger celular
) {
}
