package com.piscis.veterinaria.dto;

import com.piscis.veterinaria.entity.Dueno;
import com.piscis.veterinaria.entity.Mascota;

import java.math.BigInteger;
import java.util.List;

public record GetDuenoDTO (
        Long id_dueno,
        BigInteger dni,
        String nombre,
        String apellido,
        BigInteger celular,
        List<Mascota> mascota
){
    public GetDuenoDTO(Dueno dueno){
        this(dueno.getId_dueno(), dueno.getDni(),dueno.getNombre(),
                dueno.getApellido(), dueno.getCelular(),dueno.getMascota());
    }

}
