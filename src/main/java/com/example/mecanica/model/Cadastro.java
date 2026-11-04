package com.example.mecanica.model;

import com.example.mecanica.model.enuns.SituacaoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBCadastro")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cadastro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idCadastro;

    @Column(nullable = false, length = 100)
    private String tipoVeiculo;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoVeiculo estado;

    private LocalDate dataDecadastro;

    @OneToMany(mappedBy = "cadastro")
    private List<Registro> registros;
}
