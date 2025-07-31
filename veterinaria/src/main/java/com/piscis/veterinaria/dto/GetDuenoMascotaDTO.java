package com.piscis.veterinaria.dto;

import com.piscis.veterinaria.entity.Dueno;
import com.piscis.veterinaria.entity.Mascota;

public record GetDuenoMascotaDTO(
        String nombre_mascota,
        String especie,
        String raza,
        String nombre_dueno,
        String apellido_dueno
) {

    public GetDuenoMascotaDTO (Mascota mascota, Dueno dueno){
        this(mascota.getNombre(), mascota.getEspecie(), mascota.getRaza(), dueno.getNombre(), dueno.getApellido());
    }
}
