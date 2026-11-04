package com.example.mecanica.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ClassErroDTO (

        int status,
        LocalDateTime timestamp,
        String msg,
        List<String> detalhes
){}
