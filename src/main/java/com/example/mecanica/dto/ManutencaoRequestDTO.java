package com.example.mecanica.dto;

import com.example.mecanica.model.Cadastro;
import com.example.mecanica.model.Registro;
import com.example.mecanica.model.enuns.EstadoManutencao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ManutencaoRequestDTO(
        //dps coloco as anotacoes com NotBlank etc... vou fzr o resto primeiro

        @NotBlank(message = "Descrição e obrigatoria")
        String descricao,
        BigDecimal valor,
        LocalDate dataManutencao,
        EstadoManutencao estado,
        Long idDocadastro,
        Long idDoregistro

) {}
