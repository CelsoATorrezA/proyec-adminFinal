package com.umsa.proyec_admin.entities;

import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter

@Entity
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "empleado_id")
    private Short id;
    @Column(name = "empleado_nombre")
    private String nombre;
    @Column(name = "empleado_apellido")
    private String apellido;
    @Column(name = "empleado_direccion")
    private String direccion;
    @Column(name = "empleado_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "empleado_telefono")
    private Integer telefono;
    @Column(name = "empleado_correo")
    private String correo;
    @Column(name = "empleado_salario")
    private Integer salario;
    @Column(name = "empleado_antiguedad")
    private Integer antiguedad;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DepartamentoEntity departamento;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PuestoEntity puesto;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsuarioEntity usuario;

}
