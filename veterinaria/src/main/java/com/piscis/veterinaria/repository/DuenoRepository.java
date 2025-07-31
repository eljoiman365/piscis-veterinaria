package com.piscis.veterinaria.repository;

import com.piscis.veterinaria.entity.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno,Long> {
}
