package com.piscis.veterinaria.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.piscis.veterinaria.dto.PostDuenoDTO;
import com.piscis.veterinaria.dto.PutDuenoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Dueno {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id_dueno;
    private BigInteger dni;
    private String nombre;
    private String apellido;
    private BigInteger celular;
    @OneToMany(mappedBy = "dueno")
    @JsonManagedReference
    private List<Mascota> mascota;

    public Dueno (PostDuenoDTO postDuenoDTO){
        this.dni = postDuenoDTO.dni();
        this.nombre = postDuenoDTO.nombre();
        this.apellido = postDuenoDTO.apellido();
        this.celular = postDuenoDTO.celular();
    }

    public void editarDueno (PutDuenoDTO putDuenoDTO){
        this.dni = putDuenoDTO.dni();
        this.nombre = putDuenoDTO.nombre();
        this.apellido = putDuenoDTO.apellido();
        this.celular = putDuenoDTO.celular();
        this.mascota = putDuenoDTO.mascota();
    }

}
