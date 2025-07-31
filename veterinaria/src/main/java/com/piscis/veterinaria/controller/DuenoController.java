package com.piscis.veterinaria.controller;

import com.piscis.veterinaria.dto.*;
import com.piscis.veterinaria.entity.Dueno;
import com.piscis.veterinaria.service.DuenoService;
import com.piscis.veterinaria.service.SinDatosException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dueno")
public class DuenoController {

    @Autowired
    DuenoService duenoService;

    @GetMapping("lista-duenos")
    public ResponseEntity<List<GetDuenoDTO>> getListaDuenos(){
        return ResponseEntity.ok(duenoService.getListaDuenos());
    }

    @PostMapping("agregar-dueno")
    @Transactional
    public ResponseEntity<GetDuenoDTO> postDueno(@RequestBody PostDuenoDTO postDuenoDTO){
        return ResponseEntity.ok(duenoService.postDueno(postDuenoDTO));
    }

    @PutMapping("editar-dueno")
    @Transactional
    public ResponseEntity<GetDuenoDTO> putDueno(@RequestBody PutDuenoDTO putDuenoDTO){
        return ResponseEntity.ok(duenoService.putDueno(putDuenoDTO));
    }

    @DeleteMapping("eliminar-dueno/{id_dueno}")
    @Transactional
    public ResponseEntity<String> deleteDueno(@PathVariable Long id_dueno){
        return ResponseEntity.ok(duenoService.deleteDueno(id_dueno));
    }

    @GetMapping("lista-combinada")
    public ResponseEntity<List<GetDuenoMascotaDTO>> getListaCombinada(){
        return ResponseEntity.ok(duenoService.getCombinado());
    }

    @RestControllerAdvice
    public static class ManejadorDeExcepciones{
        @ExceptionHandler(SinDatosException.class)
        public ResponseEntity<String> mensaje (SinDatosException sinDatosException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(sinDatosException.getMessage());
        }
    }
}

