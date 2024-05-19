package com.umsa.proyec_admin.services;


import org.springframework.stereotype.Service;

import com.umsa.proyec_admin.dtos.CreateEmpleadodto;
import com.umsa.proyec_admin.dtos.Empleadodto;
import com.umsa.proyec_admin.entities.*;
import com.umsa.proyec_admin.repository.EmpleadoRepository;



import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
@Service
public class EmpleadoImpl implements IEmpleados {

    private final EmpleadoRepository empleadoRepository;
   

    public EmpleadoImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
        
    }
    

    @Override
    public List<Empleadodto> findAllEmpleados(){
        List<EmpleadoEntity> empleados= this.empleadoRepository.findAll();
        List<Empleadodto> empleadodtos = new ArrayList<Empleadodto>();
        for (EmpleadoEntity empleado : empleados) {
            Empleadodto empleadoDto = new Empleadodto();
            empleadoDto.setId(empleado.getId());
            empleadoDto.setNombre(empleado.getNombre());
            empleadoDto.setApellido(empleado.getApellido());
            empleadoDto.setCorreo(empleado.getCorreo());
            empleadoDto.setDireccion(empleado.getDireccion());
            empleadoDto.setFechaNacimiento(empleado.getFechaNacimiento());            
            empleadoDto.setTelefono(empleado.getTelefono());
            empleadoDto.setSalario(empleado.getSalario());
            empleadoDto.setAntiguedad(empleado.getAntiguedad());
            empleadodtos.add(empleadoDto);
            
        }
        return empleadodtos;
    }
    @Override
    public Optional<Empleadodto> findEmpleadoById(Short id) {
        EmpleadoEntity empleadoEntity = this.empleadoRepository.findById(id).get();

        Empleadodto empleadodto =new Empleadodto();
        if(empleadoEntity != null){
            empleadodto.setId(empleadoEntity.getId());
            empleadodto.setNombre(empleadoEntity.getNombre());
            empleadodto.setApellido(empleadoEntity.getApellido());
            empleadodto.setCorreo(empleadoEntity.getCorreo());
            empleadodto.setDireccion(empleadoEntity.getDireccion());
            empleadodto.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
            empleadodto.setTelefono(empleadoEntity.getTelefono());
            empleadodto.setSalario(empleadoEntity.getSalario());
            empleadodto.setAntiguedad(empleadoEntity.getAntiguedad());
        }
        return Optional.of(empleadodto);
    }

    @Override
    public Empleadodto createEmpleado(CreateEmpleadodto createEmpleadodto) {
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNombre(createEmpleadodto.getNombre());
        empleadoEntity.setApellido(createEmpleadodto.getApellido());
        empleadoEntity.setCorreo(createEmpleadodto.getCorreo());
        empleadoEntity.setDireccion(createEmpleadodto.getDireccion());
        empleadoEntity.setFechaNacimiento(createEmpleadodto.getFechaNacimiento());
        empleadoEntity.setTelefono(createEmpleadodto.getTelefono());
        empleadoEntity.setSalario(createEmpleadodto.getSalario());
        empleadoEntity.setAntiguedad(createEmpleadodto.getAntiguedad());

        empleadoEntity = this.empleadoRepository.save(empleadoEntity);
        Empleadodto empleadodto = new Empleadodto();
        empleadodto.setId(empleadoEntity.getId());
        empleadodto.setNombre(empleadoEntity.getNombre());
        empleadodto.setApellido(empleadoEntity.getApellido());
        empleadodto.setCorreo(empleadoEntity.getCorreo());
        empleadodto.setDireccion(empleadoEntity.getDireccion());
        empleadodto.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
        empleadodto.setTelefono(empleadoEntity.getTelefono());
        empleadodto.setSalario(empleadoEntity.getSalario());
        empleadodto.setAntiguedad(empleadoEntity.getAntiguedad());

        return empleadodto;
    }
    @Override
    public Empleadodto updateEmpleado(CreateEmpleadodto updateEmpleadodto, Short id) {
        EmpleadoEntity empleadoEntity = this.empleadoRepository.findById(id).get();
        empleadoEntity.setNombre(updateEmpleadodto.getNombre());
        empleadoEntity.setApellido(updateEmpleadodto.getApellido());
        empleadoEntity.setCorreo(updateEmpleadodto.getCorreo());
        empleadoEntity.setDireccion(updateEmpleadodto.getDireccion());
        empleadoEntity.setFechaNacimiento(updateEmpleadodto.getFechaNacimiento());
        empleadoEntity.setTelefono(updateEmpleadodto.getTelefono());
        empleadoEntity.setSalario(updateEmpleadodto.getSalario());
        empleadoEntity.setAntiguedad(updateEmpleadodto.getAntiguedad());
        empleadoEntity = this.empleadoRepository.save(empleadoEntity);

        Empleadodto empleadodto = new Empleadodto();

        empleadodto.setId(empleadoEntity.getId());
        empleadodto.setNombre(empleadoEntity.getNombre());
        empleadodto.setApellido(empleadoEntity.getApellido());
        empleadodto.setCorreo(empleadoEntity.getCorreo());
        empleadodto.setDireccion(empleadoEntity.getDireccion());
        empleadodto.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
        empleadodto.setTelefono(empleadoEntity.getTelefono());
        empleadodto.setSalario(empleadoEntity.getSalario());
        empleadodto.setAntiguedad(empleadoEntity.getAntiguedad());

        return empleadodto;
    }
    @Override
    public void deleteEmpleado(Short id) {
       this.empleadoRepository.deleteById(id);
    }
 
}
