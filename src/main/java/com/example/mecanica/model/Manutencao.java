package com.example.mecanica.model;


import com.example.mecanica.model.enuns.EstadoManutencao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "TbManutencao")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manutencao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idManu;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    private LocalDate dataManutencao;

    @Enumerated(EnumType.STRING)
    private EstadoManutencao estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cadastro")
    private Cadastro cadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_registro")
    private Registro registro;
}
