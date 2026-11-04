package com.example.mecanica.controller;

import com.example.mecanica.Service.CadastroService;
import com.example.mecanica.dto.CadastroRequestDTO;
import com.example.mecanica.dto.CadastroResponseDTO;
import com.example.mecanica.model.Cadastro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Cadastro")
@RequiredArgsConstructor
public class CadastroController {

    private final CadastroService cadastroService;

    @GetMapping
    public List<CadastroResponseDTO> listarALL() {
        return cadastroService.listarALL();
    }

    @GetMapping("/{idCadastro}")
    public CadastroResponseDTO buscarCadPorId(@PathVariable Long idCadastro) {
        return cadastroService.buscarCadPorId(idCadastro);
    }

    @PostMapping
    public CadastroResponseDTO cadastroVeiculo(@Valid @RequestBody CadastroRequestDTO dto) {
        return cadastroService.cadastroVeiculo(dto);
    }

    @PutMapping("/{idCadastro}")
    public CadastroResponseDTO attCadastros(@PathVariable Long idCadastro,
                                            @Valid @RequestBody CadastroRequestDTO dto) {
        return cadastroService.attCadastros(idCadastro, dto);
    }

    @DeleteMapping("/deletar/{idCadastro}")
    public void deletarCadastro(@PathVariable Long idCadastro){
         cadastroService.deletarCadastro(idCadastro);
    }
}
