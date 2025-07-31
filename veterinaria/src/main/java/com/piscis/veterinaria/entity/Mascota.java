package com.piscis.veterinaria.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piscis.veterinaria.dto.PostMascotaDTO;
import com.piscis.veterinaria.dto.PutDuenoDTO;
import com.piscis.veterinaria.dto.PutMascotaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Mascota {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @ManyToOne
    @JoinColumn(name = "id_dueno")
    @JsonIgnore
    private Dueno dueno;

    public Mascota (PostMascotaDTO postMascotaDTO){
        this.nombre = postMascotaDTO.nombre();
        this.especie = postMascotaDTO.especie();
        this.raza = postMascotaDTO.raza();
        this.color = postMascotaDTO.color();
    }

    public void editarMascota (PutMascotaDTO putMascotaDTO){
        this.nombre = putMascotaDTO.nombre();
        this.especie = putMascotaDTO.especie();
        this.raza = putMascotaDTO.raza();
        this.color = putMascotaDTO.color();
        this.dueno = putMascotaDTO.dueno();
    }
}
