package com.example.geminis.EjemploTest;

import com.example.geminis.dto.EjemploDTO;
public class BaseEjemploTest {

    protected EjemploDTO construir() {
        return EjemploDTO.builder().id(1).name("name").email("emial@gmail.com").build();
    }

}
