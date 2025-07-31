package com.piscis.veterinaria.controller;

import com.piscis.veterinaria.dto.GetMascotaDTO;
import com.piscis.veterinaria.dto.PostMascotaDTO;
import com.piscis.veterinaria.dto.PutMascotaDTO;
import com.piscis.veterinaria.entity.Mascota;
import com.piscis.veterinaria.service.MascotaService;
import com.piscis.veterinaria.service.SinDatosException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mascota")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @GetMapping("lista-mascotas")
    public ResponseEntity<List<GetMascotaDTO>> getListaMascotas(){
        return ResponseEntity.ok(mascotaService.getListaMascotas());
    }

    @PostMapping("agregar-mascota")
    @Transactional
    public ResponseEntity<GetMascotaDTO> postDueno(@RequestBody PostMascotaDTO postMascotaDTO){
        return ResponseEntity.ok(mascotaService.postMascota(postMascotaDTO));
    }

    @PutMapping("editar-mascota")
    @Transactional
    public ResponseEntity<GetMascotaDTO> putDueno(@RequestBody PutMascotaDTO putMascotaDTO){
        return ResponseEntity.ok(mascotaService.putMascota(putMascotaDTO));
    }

    @DeleteMapping("eliminar-mascota/{id_mascota}")
    @Transactional
    public ResponseEntity<String> deleteMascota(@PathVariable Long id_mascota){
        return ResponseEntity.ok(mascotaService.deleteMascota(id_mascota));
    }

    @GetMapping("lista-filtrada-mascotas")
    public ResponseEntity<List<GetMascotaDTO>> getListaFiltrada(@RequestParam String especie, String raza){
        return ResponseEntity.ok(mascotaService.getMascotaRaza(especie,raza));
    }

    @RestControllerAdvice
    public static class ManejadorDeExcepciones{
        @ExceptionHandler(SinDatosException.class)
        public ResponseEntity<String> mansajeExcepcion(SecurityException securityException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(securityException.getMessage());
        }
    }
}
