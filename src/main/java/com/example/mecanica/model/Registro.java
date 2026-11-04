package com.example.mecanica.model;

import com.example.mecanica.model.enuns.EstadoRegistro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "TBLog")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long idLog;

    @Column(unique = true, name = "Codigo unico", nullable = false)
    private String cod;

    @Column(length = 10000)
    private StringBuilder descricao;

    @Enumerated(EnumType.STRING)
    private EstadoRegistro estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cadastro", nullable = false)
    private Cadastro cadastro;


}
