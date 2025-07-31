package com.piscis.veterinaria.dto;

import com.piscis.veterinaria.entity.Dueno;
import com.piscis.veterinaria.entity.Mascota;


public record GetMascotaDTO(
        Long id_mascota,
        String nombre,
        String especie,
        String raza,
        String color
) {
    public GetMascotaDTO(Mascota mascota){
        this(mascota.getId_mascota(), mascota.getNombre(), mascota.getEspecie(), mascota.getRaza(), mascota.getColor());
    }
}
