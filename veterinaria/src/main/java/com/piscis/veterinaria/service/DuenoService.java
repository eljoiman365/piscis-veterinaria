package com.piscis.veterinaria.service;

import com.piscis.veterinaria.dto.GetDuenoDTO;
import com.piscis.veterinaria.dto.GetDuenoMascotaDTO;
import com.piscis.veterinaria.dto.PostDuenoDTO;
import com.piscis.veterinaria.dto.PutDuenoDTO;
import com.piscis.veterinaria.entity.Dueno;
import com.piscis.veterinaria.entity.Mascota;
import com.piscis.veterinaria.repository.DuenoRepository;
import com.piscis.veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuenoService implements IDuenoService{

    @Autowired
    private DuenoRepository duenoRepository;
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<GetDuenoDTO> getListaDuenos() {
        List<Dueno> listaDuenosEncontrada = duenoRepository.findAll();
        List<GetDuenoDTO> listaDuenos = new ArrayList<>();

        for (Dueno d : listaDuenosEncontrada){
            GetDuenoDTO duenoDTO = new GetDuenoDTO(d.getId_dueno(),d.getDni(),d.getNombre(),
                    d.getApellido(),d.getCelular(),d.getMascota());
            listaDuenos.add(duenoDTO);
        }
        return listaDuenos;
    }

    @Override
    public GetDuenoDTO postDueno(PostDuenoDTO postDuenoDTO) {
        Dueno duenoNuevo = new Dueno(postDuenoDTO);
        duenoRepository.save(duenoNuevo);
        return new GetDuenoDTO(duenoNuevo);
    }

    @Override
    public GetDuenoDTO putDueno(PutDuenoDTO putDuenoDTO) {
        Dueno editarDueno = duenoRepository.getReferenceById(putDuenoDTO.id_dueno());
        editarDueno.editarDueno(putDuenoDTO);
        duenoRepository.save(editarDueno);
        return new GetDuenoDTO(editarDueno);
    }

    @Override
    public String deleteDueno(Long id) {
        if (duenoRepository.existsById(id)) {
            duenoRepository.deleteById(id);
            return "Registro eliminado con exito!!!";
        }else throw new SinDatosException("El id ingresado no se encuentra registrado en la base de datos!!!");
    }

    @Override
    public List<GetDuenoMascotaDTO> getCombinado() {
        List<Dueno> duenos = duenoRepository.findAll();
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<GetDuenoMascotaDTO> listaDuenoMascota = new ArrayList<>();

        for (Dueno d : duenos){
            for (Mascota m : mascotas){
                GetDuenoMascotaDTO datosCombinados = new GetDuenoMascotaDTO(m.getNombre(),m.getEspecie(),m.getRaza(),
                        d.getNombre(),d.getApellido());
                listaDuenoMascota.add(datosCombinados);
            }
        }
        return listaDuenoMascota;
    }
}
