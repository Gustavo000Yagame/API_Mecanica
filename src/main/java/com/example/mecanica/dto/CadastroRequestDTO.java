package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.SituacaoVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroRequestDTO (

        @NotBlank(message = "Digite o tipo do veiculo ex..( Moto carro)")
        @Size(max = 100)
        String tipoVeiculo,

        @NotBlank(message = "Modelo e obrigatorio")
        String modelo,

        SituacaoVeiculo estado,
        LocalDate dataDecadastro

){}
