package com.example.mecanica.controller;

import com.example.mecanica.Service.CadastroService;
import com.example.mecanica.Service.RegistroService;
import com.example.mecanica.dto.RegistroRequestDTO;
import com.example.mecanica.dto.RegistroResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Registro")
@RequiredArgsConstructor
public class RegistroController {

    private final CadastroService cadastroService;
    private final RegistroService registroService;

    @PostMapping
    public RegistroResponseDTO cadastrarRegistro(@Valid @RequestBody RegistroRequestDTO dto){
        return registroService.cadastrarRegistro(dto);
    }

    @GetMapping
    public List<RegistroResponseDTO> listarAllRegistros(){
        return registroService.listarAllRegistros();
    }

    @GetMapping("/{idLog}")
    public RegistroResponseDTO buscarRegistroPorId(@PathVariable Long idLog){
        return registroService.buscarRegistroPorId(idLog);
    }

    @PutMapping("/{idLog}")
    public RegistroResponseDTO atualizarRegistro(@PathVariable Long idLog, @Valid @RequestBody RegistroRequestDTO dto){
        return registroService.atualizarRegistro(idLog, dto);
    }

    @DeleteMapping
    public void deletarRegistro(@PathVariable Long idLog){
        registroService.deletarRegistro(idLog);
    }
}
