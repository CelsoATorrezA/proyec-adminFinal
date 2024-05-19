package com.umsa.proyec_admin.dtos;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVacacionesDto {
     
    
    
    private LocalDate fechaInicio;
    
    private LocalDate fechaFin;
    
    private String motivo;
}
