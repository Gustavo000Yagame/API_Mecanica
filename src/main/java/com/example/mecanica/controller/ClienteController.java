package com.example.mecanica.controller;

import com.example.mecanica.Service.CadastroService;
import com.example.mecanica.Service.ClienteService;
import com.example.mecanica.dto.ClienteRequestDTO;
import com.example.mecanica.dto.ClienteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("/Cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final CadastroService cadastroService;

    @PostMapping
    public ClienteResponseDTO cadastrarCliente(@Valid @RequestBody ClienteRequestDTO dto){
        return clienteService.cadastrarCliente(dto);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizarCliente(@Valid @RequestBody ClienteRequestDTO dto,
                                               @PathVariable Long id){
        return clienteService.atualizarCliente(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }

    @GetMapping
    public List<ClienteResponseDTO> listarTodosClientes(){
       return clienteService.listarTodosClientes();
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }
}