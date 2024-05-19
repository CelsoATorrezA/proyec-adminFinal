package com.umsa.proyec_admin.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleadodto {


    private Short id;
    
    private String nombre;
    
    private String apellido;
   
    private String direccion;
    
    private LocalDate fechaNacimiento;
   
    private Integer telefono;
    
    private String correo;

    private Integer salario;

    private Integer antiguedad;
}
