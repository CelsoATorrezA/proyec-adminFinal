package com.umsa.proyec_admin.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroEntity {
    @Id
    @Column(name = "registro_id")
    private Short id;
    @Column(name = "registro_entrada")
    private Date fechaHoraentrada;
    @Column(name = "registro_salida")
    private Date fechaHoraSalida;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmpleadoEntity empleado;
}
