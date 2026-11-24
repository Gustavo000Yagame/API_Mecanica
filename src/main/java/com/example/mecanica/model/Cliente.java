package com.example.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "TbCliente")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nomeCliente;

    @Column(nullable = false, length = 11)
    private String tellCliente;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    private LocalDate dataCadastro;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Cadastro> cadastroList;
}
