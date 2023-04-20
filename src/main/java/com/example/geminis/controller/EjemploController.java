package com.example.geminis.controller;

import com.example.geminis.dto.EjemploDTO;
import com.example.geminis.util.Messages;
import com.example.geminis.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/api/ejemplo/")
public class EjemploController
{
    private final Messages messages;

    public EjemploController(Messages messages) {
        this.messages = messages;
    }

    @PostMapping
    @ApiOperation(value = "permite crear ejemplo dto", response = EjemploDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El ejemplo DTO fue creado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EjemploDTO>> crear(@Validated @RequestBody EjemploDTO ejemploDTO) {
        EjemploDTO ejemploDTO2 = new EjemploDTO();
        EjemploDTO ejemploDTO1 = EjemploDTO.builder()
                .id(1234)
                .email("email@gmail.com")
                .name("name")
                .build();
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.CREATED, messages.get("message.ejemplo.succes.creacion"), ejemploDTO1));
    }

    @PutMapping
    @ApiOperation(value = "permite actualizar ejemplo dto", response = EjemploDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El ejemplo DTO fue listado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EjemploDTO>> actualizar(@Validated @RequestBody EjemploDTO ejemploDTO) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.UPDATED, messages.get("message.ejemplo.succes.actualizacion"), ejemploDTO));
    }

    @PutMapping("accion")
    @ApiOperation(value = "permite accionar ejemplo dto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "El ejemplo DTO fue listado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse> accionar() {
        return ResponseEntity.ok(new StandardResponse<>(messages.get("message.ejemplo.succes.creacion"), StandardResponse.StatusStandardResponse.ACCION_OK));
    }

    @GetMapping()
    @ApiOperation(value = "Permite listar ejemplos dto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los ejemplos DTO fue listado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<List<EjemploDTO>>> listar() {
        EjemploDTO ejemploDTO1 = EjemploDTO.builder()
                .id(1234)
                .email("email@gmail.com")
                .name("name")
                .build();
        List<EjemploDTO> ejemploDTOS = new ArrayList<>();
        ejemploDTOS.add(ejemploDTO1);
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.UPDATED, messages.get("message.ejemplo.succes.actualizacion"), ejemploDTOS));
    }
}
