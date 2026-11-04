package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.EstadoRegistro;

public record RegistroResponseDTO (

        Long idLog,
        String cod,
        StringBuilder descricao,
        EstadoRegistro estado,
        Long idCadt,
        String tipoDoVeiculo,
        String modeloDoVeiculo
){}
