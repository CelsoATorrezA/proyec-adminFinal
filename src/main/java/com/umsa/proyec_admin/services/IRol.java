package com.umsa.proyec_admin.services;

import java.util.List;
import java.util.Optional;

import com.umsa.proyec_admin.dtos.CreateRolDto;
import com.umsa.proyec_admin.dtos.RolDto;

public interface IRol {
    List<RolDto> findAllRoles();

    Optional<RolDto> findRolById(Short id);

    RolDto createRol(CreateRolDto rolEntity);

    RolDto updateRol(CreateRolDto rolEntity, Short id);

    void deleteRol(Short id);
}
