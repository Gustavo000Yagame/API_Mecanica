package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.SituacaoVeiculo;

import java.time.LocalDate;

public record CadastroResponseDTO (

        Long idCadastro,
        String tipoVeiculo,
        String modelo,
        SituacaoVeiculo estado,
        LocalDate dataDecadastro
){}
