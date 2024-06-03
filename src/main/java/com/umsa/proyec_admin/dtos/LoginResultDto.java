package com.umsa.proyec_admin.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResultDto {

    private Short id;
    
    private String nombreusu;
    
    private String password;


    private String nombreRol;
}
