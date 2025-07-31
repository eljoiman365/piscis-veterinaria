package com.piscis.veterinaria.dto;

import com.piscis.veterinaria.entity.Dueno;

public record PutMascotaDTO(
        Long id_mascota,
        String nombre,
        String especie,
        String raza,
        String color,
        Dueno dueno
) {
}
