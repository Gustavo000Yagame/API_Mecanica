package com.example.mecanica.dto;

import java.time.LocalDate;
import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String nomeCliente,
        String tellCliente,
        String cpf,
        LocalDate dataCadastro,
        String email,
        List<CadastroResponseDTO> cadastros
) {}