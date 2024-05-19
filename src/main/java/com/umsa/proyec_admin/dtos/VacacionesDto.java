package com.umsa.proyec_admin.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacacionesDto {
    
    private Short id;
    
    private LocalDate fechaInicio;
    
    private LocalDate fechaFin;
    
    private String motivo;

}
