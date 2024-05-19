package com.umsa.proyec_admin.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DepartamentoEntity {

    @Id
    @Column(name = "departamento_id")
    private Short id;
    @Column(name = "departamento_nombre")
    private String nombreDepartamento;

    @Column(name= "departamento_descripcion")
    private String descripcion;

    @jakarta.persistence.OneToOne()
    private EmpleadoEntity empleado;

}
