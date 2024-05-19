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
public class VacacionesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @Column(name = "vacaciones_id")
    private Short id;
    @Column(name = "vacaciones_inicio")
    private LocalDate fechaInicio;
    @Column(name = "vacaciones_fin")
    private LocalDate fechaFin;
    @Column(name = "vacaciones_motivo")
    private String motivo;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmpleadoEntity empleado;
}
