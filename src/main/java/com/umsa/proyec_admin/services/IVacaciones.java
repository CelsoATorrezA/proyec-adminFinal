package com.umsa.proyec_admin.services;

import java.util.List;
import java.util.Optional;

import com.umsa.proyec_admin.dtos.CreateVacacionesDto;
import com.umsa.proyec_admin.dtos.VacacionesDto;

public interface IVacaciones {

    List<VacacionesDto> findAllVacaciones();

    Optional<VacacionesDto> findVacacionById(Short id);

    VacacionesDto createVacaciones(CreateVacacionesDto vacacionesentiti);

    VacacionesDto updateVacaciones(CreateVacacionesDto vacacionesentiti, Short id);

    void deleteVacaciones(Short id);
}
