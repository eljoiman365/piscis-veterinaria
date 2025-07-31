package com.piscis.veterinaria.repository;

import com.piscis.veterinaria.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
    public List<Mascota> findByEspecieAndRazaContainingIgnoreCase(String nombre, String raza);
}
