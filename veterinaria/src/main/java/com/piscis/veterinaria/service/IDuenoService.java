package com.piscis.veterinaria.service;

import com.piscis.veterinaria.dto.GetDuenoDTO;
import com.piscis.veterinaria.dto.GetDuenoMascotaDTO;
import com.piscis.veterinaria.dto.PostDuenoDTO;
import com.piscis.veterinaria.dto.PutDuenoDTO;
import com.piscis.veterinaria.entity.Dueno;

import java.util.List;

public interface IDuenoService {
    public List<GetDuenoDTO> getListaDuenos();
    public GetDuenoDTO postDueno(PostDuenoDTO postDuenoDTO);
    public GetDuenoDTO putDueno(PutDuenoDTO putDuenoDTO);
    public String deleteDueno(Long id);
    public List<GetDuenoMascotaDTO> getCombinado();
}
