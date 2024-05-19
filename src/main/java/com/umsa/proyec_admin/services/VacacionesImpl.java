package com.umsa.proyec_admin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.umsa.proyec_admin.dtos.CreateVacacionesDto;
import com.umsa.proyec_admin.dtos.VacacionesDto;
import com.umsa.proyec_admin.entities.VacacionesEntity;
import com.umsa.proyec_admin.repository.VacacionesRepository;

@Service
public class VacacionesImpl implements IVacaciones {


    private final VacacionesRepository vacacionesRepository;
        

    public VacacionesImpl (VacacionesRepository vacacionesRepository){
        this.vacacionesRepository=vacacionesRepository;
    }

    @Override
    public List<VacacionesDto> findAllVacaciones() {
        List<VacacionesEntity> vacacion= this.vacacionesRepository.findAll();
        List<VacacionesDto> vacacionesdto= new ArrayList<VacacionesDto>();
        for (VacacionesEntity vacaciones : vacacion) {
            VacacionesDto vacacionesDto = new VacacionesDto();
            vacacionesDto.setId(vacaciones.getId());
            vacacionesDto.setFechaInicio(vacaciones.getFechaInicio());
            vacacionesDto.setFechaFin(vacaciones.getFechaFin());
            vacacionesDto.setMotivo(vacaciones.getMotivo());
            vacacionesdto.add(vacacionesDto);
        }
        return vacacionesdto;
    }


    @Override
    public Optional<VacacionesDto> findVacacionById(Short id) {
        VacacionesEntity vacacion = this.vacacionesRepository.findById(id).get();

        VacacionesDto vacacionesDto = new VacacionesDto();
        if(vacacion != null){

            vacacionesDto.setId(vacacion.getId());
            vacacionesDto.setFechaInicio(vacacion.getFechaInicio());
            vacacionesDto.setFechaFin(vacacion.getFechaFin());
            vacacionesDto.setMotivo(vacacion.getMotivo());
        }

        return Optional.of(vacacionesDto);
    }
    @Override
    public VacacionesDto createVacaciones(CreateVacacionesDto vacacionesentiti) {
        VacacionesEntity vacacionesEntity = new VacacionesEntity();
        vacacionesEntity.setFechaInicio(vacacionesentiti.getFechaInicio());
        vacacionesEntity.setFechaFin(vacacionesentiti.getFechaFin());
        vacacionesEntity.setMotivo(vacacionesentiti.getMotivo());

        vacacionesEntity = this.vacacionesRepository.save(vacacionesEntity);
        VacacionesDto vacacionesDto = new VacacionesDto();
        vacacionesDto.setId(vacacionesEntity.getId());
        vacacionesDto.setFechaInicio(vacacionesEntity.getFechaInicio());
        vacacionesDto.setFechaFin(vacacionesDto.getFechaFin());
        vacacionesDto.setMotivo(vacacionesEntity.getMotivo());

        return vacacionesDto;
    }
    @Override
    public VacacionesDto updateVacaciones(CreateVacacionesDto updatevacacionesentiti, Short id) {
       VacacionesEntity vacacionesEntity = this.vacacionesRepository.findById(id).get();
        vacacionesEntity.setFechaInicio(updatevacacionesentiti.getFechaInicio());
        vacacionesEntity.setFechaFin(updatevacacionesentiti.getFechaFin());
        vacacionesEntity.setMotivo(updatevacacionesentiti.getMotivo());
        vacacionesEntity = this.vacacionesRepository.save(vacacionesEntity);

        VacacionesDto vacacionesDto= new VacacionesDto();
        vacacionesDto.setId(vacacionesEntity.getId());
        vacacionesDto.setFechaInicio(vacacionesEntity.getFechaInicio());
        vacacionesDto.setFechaFin(vacacionesEntity.getFechaFin());
        vacacionesDto.setMotivo(vacacionesEntity.getMotivo());


        return vacacionesDto;
    }

    @Override
    public void deleteVacaciones(Short id) {
        this.vacacionesRepository.deleteById(id);
        
    }
    


    

}
