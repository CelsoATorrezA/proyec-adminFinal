package com.umsa.proyec_admin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umsa.proyec_admin.services.IEmpleados;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.umsa.proyec_admin.dtos.CreateEmpleadodto;
import com.umsa.proyec_admin.dtos.Empleadodto;


@RequestMapping("/empleados")
@RestController
public class EmpleadoController {


    private final IEmpleados empleadosservices;

    public EmpleadoController(IEmpleados empleadosservices){
        this.empleadosservices=empleadosservices;
    }
    @GetMapping()
        public List <Empleadodto> findAllEmpleados(){
            return this.empleadosservices.findAllEmpleados();
    }
    @GetMapping("/{id}")
        public Optional<Empleadodto> findOneById(@PathVariable Short id){
            return this.empleadosservices.findEmpleadoById(id);
        }
    @PostMapping()
        public Empleadodto createEmpleadodto(@RequestBody CreateEmpleadodto empleado){
            return this.empleadosservices.createEmpleado(empleado);
        }
     @PutMapping("/{id}")
        public Empleadodto updateEmpleadodto(@RequestBody CreateEmpleadodto empleado, @PathVariable Short id){
            return this.empleadosservices.updateEmpleado(empleado, id);
        }
    @DeleteMapping("/{id}")
        public void deleteEmpleadoById(@PathVariable Short id){
            this.empleadosservices.deleteEmpleado(id);
        }



    }
    