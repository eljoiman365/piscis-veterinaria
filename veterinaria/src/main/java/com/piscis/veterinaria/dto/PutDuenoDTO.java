package com.piscis.veterinaria.dto;

import com.piscis.veterinaria.entity.Mascota;

import java.math.BigInteger;
import java.util.List;

public record PutDuenoDTO(
        Long id_dueno,
        BigInteger dni,
        String nombre,
        String apellido,
        BigInteger celular,
        List<Mascota> mascota
) {
}
