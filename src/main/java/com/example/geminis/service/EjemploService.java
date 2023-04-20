package com.example.geminis.service;

import com.example.geminis.dto.EjemploDTO;
import org.springframework.stereotype.Service;

@Service
public class EjemploService {

    public EjemploDTO crear(EjemploDTO ejemploDTO) {
        ejemploDTO.setName(ejemploDTO.getName().concat(ejemploDTO.getEmail()));
        return ejemploDTO;
    }

    public EjemploDTO crearOtro(EjemploDTO ejemploDTO) {
        return ejemploDTO;
    }
}
