package com.example.mecanica.repository;

import com.example.mecanica.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepositoy extends JpaRepository<Manutencao, Long> {
}
