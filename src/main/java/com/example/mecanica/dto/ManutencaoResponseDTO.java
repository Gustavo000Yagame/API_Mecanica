package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.EstadoManutencao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ManutencaoResponseDTO(

        Long idManu,
        String descricao,
        BigDecimal valor,
        LocalDate dataManutencao,
        EstadoManutencao estado,
        Long idDocadas,
        Long idDoreg
){}
