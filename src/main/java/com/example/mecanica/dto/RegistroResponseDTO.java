package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.EstadoRegistro;

public record RegistroResponseDTO (

        Long idLog,
        String cod,
        String descricao,
        EstadoRegistro estado,
        Long idCadt,
        String tipoDoVeiculo,
        String modeloDoVeiculo
){}
