package com.piscis.veterinaria.service;

import com.piscis.veterinaria.dto.GetDuenoMascotaDTO;
import com.piscis.veterinaria.dto.GetMascotaDTO;
import com.piscis.veterinaria.dto.PostMascotaDTO;
import com.piscis.veterinaria.dto.PutMascotaDTO;
import com.piscis.veterinaria.entity.Mascota;
import java.util.List;


public interface IMascotaService {
    public List<GetMascotaDTO> getListaMascotas();
    public GetMascotaDTO postMascota(PostMascotaDTO postMascotaDTO);
    public GetMascotaDTO putMascota(PutMascotaDTO putMascotaDTO);
    public String deleteMascota(Long id);
    public List<GetMascotaDTO>  getMascotaRaza(String especie, String raza);
}
