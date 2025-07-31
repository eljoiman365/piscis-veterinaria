package com.piscis.veterinaria.service;

import com.piscis.veterinaria.dto.GetMascotaDTO;
import com.piscis.veterinaria.dto.PostMascotaDTO;
import com.piscis.veterinaria.dto.PutMascotaDTO;
import com.piscis.veterinaria.entity.Mascota;
import com.piscis.veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public List<GetMascotaDTO> getListaMascotas() {
       List<Mascota> listaMascotaEncontrada = mascotaRepository.findAll();
       List<GetMascotaDTO> listaMascotas = new ArrayList<>();

       for (Mascota m : listaMascotaEncontrada){
           GetMascotaDTO mascotaDTO = new GetMascotaDTO(m.getId_mascota(),m.getNombre(),m.getEspecie(),m.getRaza(),
                   m.getColor());
           listaMascotas.add(mascotaDTO);
       }
        return listaMascotas;
    }

    @Override
    public GetMascotaDTO postMascota(PostMascotaDTO postMascotaDTO) {
        Mascota mascotaNueva = new Mascota(postMascotaDTO);
        mascotaRepository.save(mascotaNueva);
        return new GetMascotaDTO(mascotaNueva);
    }

    @Override
    public GetMascotaDTO putMascota(PutMascotaDTO putMascotaDTO) {
        Mascota mascotaReferencia = mascotaRepository.getReferenceById(putMascotaDTO.id_mascota());
        mascotaReferencia.editarMascota(putMascotaDTO);
        mascotaRepository.save(mascotaReferencia);
        return new GetMascotaDTO(mascotaReferencia);
    }

    @Override
    public String deleteMascota(Long id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return "Datos eliminados con exito!!!";
        }
        else throw new SinDatosException("El id indicado no existe en la base de datos!!!");
    }

    @Override
    public List<GetMascotaDTO> getMascotaRaza(String especie, String raza) {
        if (especie.toLowerCase().contains("perro") && raza.toLowerCase().contains("caniche")) {
            List<Mascota> listaEncontrada = mascotaRepository.findByEspecieAndRazaContainingIgnoreCase(especie, raza);
            List<GetMascotaDTO> listaMascotaDto = new ArrayList<>();

            for (Mascota c : listaEncontrada){
                GetMascotaDTO mascotaDTO = new GetMascotaDTO(c.getId_mascota(),c.getNombre(),c.getEspecie(),c.getRaza(),
                        c.getColor());
                listaMascotaDto.add(mascotaDTO);
            }
            return listaMascotaDto;
        }else throw new SinDatosException("Los datos ingresados no cumplen la condición");
    }
}
