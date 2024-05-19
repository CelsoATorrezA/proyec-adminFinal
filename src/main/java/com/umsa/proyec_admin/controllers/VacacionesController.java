package com.umsa.proyec_admin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umsa.proyec_admin.dtos.CreateVacacionesDto;

import com.umsa.proyec_admin.dtos.VacacionesDto;
import com.umsa.proyec_admin.services.IVacaciones;

@RequestMapping("/vacaciones")
@RestController()
public class VacacionesController {
    private final IVacaciones vacacionesServices;

    public VacacionesController(IVacaciones vacacionesServices){
        this.vacacionesServices=vacacionesServices;
    }

    @GetMapping()
        public List <VacacionesDto> findAllVacaciones(){
            return this.vacacionesServices.findAllVacaciones();
    }
    @GetMapping("/{id}")
        public Optional<VacacionesDto> findOneById(@PathVariable Short id){
            return this.vacacionesServices.findVacacionById(id);
        }
    @PostMapping()
        public VacacionesDto createVacacionesdodto(@RequestBody CreateVacacionesDto vacaciones){
            return this.vacacionesServices.createVacaciones(vacaciones);
        }
     @PutMapping("/{id}")
        public VacacionesDto updateVacacionesdodto(@RequestBody CreateVacacionesDto vacaciones, @PathVariable Short id){
            return this.vacacionesServices.updateVacaciones(vacaciones, id);
        }
    @DeleteMapping("/{id}")
        public void deleteVacacionesById(@PathVariable Short id){
            this.vacacionesServices.deleteVacaciones(id);
        }

}
