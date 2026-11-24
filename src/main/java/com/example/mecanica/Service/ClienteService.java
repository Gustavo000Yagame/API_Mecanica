
package com.example.mecanica.Service;

import com.example.mecanica.dto.CadastroResponseDTO;
import com.example.mecanica.dto.ClienteRequestDTO;
import com.example.mecanica.dto.ClienteResponseDTO;
import com.example.mecanica.model.Cliente;
import com.example.mecanica.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private ClienteResponseDTO convertToResponseCliente(Cliente cliente) {

        List<CadastroResponseDTO> cadastros = cliente.getCadastroList()
                .stream()
                .map(cadastro -> new CadastroResponseDTO(
                        cadastro.getIdCadastro()
                ))
                .toList();

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNomeCliente(),
                cliente.getTellCliente(),
                cliente.getCpf(),
                cliente.getDataCadastro(),
                cliente.getEmail(),
                cadastros
        );
    }

    public ClienteResponseDTO cadastrarCliente(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();

        cliente.setNomeCliente(dto.nomeCliente());
        cliente.setTellCliente(dto.tellCliente());
        cliente.setCpf(dto.cpf());
        cliente.setDataCadastro(dto.dataCadastro());
        cliente.setEmail(dto.email());

        Cliente newCliente = clienteRepository.save(cliente);
        return convertToResponseCliente(newCliente);
    }

    public ClienteResponseDTO atualizarCliente(Long idCliente, ClienteRequestDTO dto){
        Cliente clienteAtt = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));

        clienteAtt.setNomeCliente(dto.nomeCliente());
        clienteAtt.setTellCliente(dto.tellCliente());
        clienteAtt.setCpf(dto.cpf());
        clienteAtt.setDataCadastro(dto.dataCadastro());
        clienteAtt.setEmail(dto.email());

        Cliente attCliente = clienteRepository.save(clienteAtt);
        return convertToResponseCliente(attCliente);
    }

    public void deletarCliente(Long idCliente){
        Cliente clienteEncontrado = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente Nao" +
                        "Encontrado"));

        clienteRepository.delete(clienteEncontrado);
    }

    public ClienteResponseDTO buscarClientePorId(Long idClienteBuscaId){
        Cliente cliente = clienteRepository.findById(idClienteBuscaId)
                .orElseThrow(() -> new RuntimeException("Cliente Nao encontrado"));

        return convertToResponseCliente(cliente);
    }

    public List<ClienteResponseDTO> listarTodosClientes(){
        return clienteRepository.findAll().stream().
                map(this::convertToResponseCliente).
                toList();
    }
}
