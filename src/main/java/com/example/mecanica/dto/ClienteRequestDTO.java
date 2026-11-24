package com.example.mecanica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClienteRequestDTO(
        Long id,

        @NotBlank(message = "O nome do cliente e obrigatorio")
        @Size(max = 150)
        String nomeCliente,
        @NotBlank(message = "O telefone do cliente e obrigatorio")
        @Size(max = 11)
        String tellCliente,
        @NotBlank(message = "O cpf do cliente e obrigatorio")
        @Size(max = 11)
        String cpf,
        LocalDate dataCadastro,
        @Email(message = "O Email do cliente e obrigatorio")
        String email
){}
