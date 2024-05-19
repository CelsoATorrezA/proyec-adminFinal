package com.umsa.proyec_admin.services;

import java.util.List;
import java.util.Optional;

import com.umsa.proyec_admin.dtos.*;

public interface IEmpleados {


    List<Empleadodto> findAllEmpleados();

    Optional<Empleadodto> findEmpleadoById(Short id);

    Empleadodto createEmpleado(CreateEmpleadodto empleadoentiti);

    Empleadodto updateEmpleado(CreateEmpleadodto empleadoentiti, Short id);

    void deleteEmpleado(Short id);



}
