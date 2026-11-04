package com.example.mecanica.dto;

import com.example.mecanica.model.enuns.EstadoRegistro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroRequestDTO(

        Long idLog,

        @NotBlank(message = "codigo de registro obrigatorio!!")
        String cod,

        @NotBlank(message = "Descricao obrigatoria!")
        @Size(min = 100)
        StringBuilder descricao,

        EstadoRegistro estado,
        Long idCadt

) {}
