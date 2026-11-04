package com.example.mecanica.Service;

import com.example.mecanica.dto.RegistroRequestDTO;
import com.example.mecanica.dto.RegistroResponseDTO;
import com.example.mecanica.model.Cadastro;
import com.example.mecanica.model.Registro;
import com.example.mecanica.repository.CadastroRepository;
import com.example.mecanica.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final RegistroRepository registroRepository;
    private final CadastroRepository cadastroRepository;

    private RegistroResponseDTO convertertoRespons(Registro registro){
        return new RegistroResponseDTO(
                registro.getIdLog(),
                registro.getCod(),
                registro.getDescricao(),
                registro.getEstado(),
                registro.getCadastro().getIdCadastro(),
                registro.getCadastro().getTipoVeiculo(),
                registro.getCadastro().getModelo()
        );
    }
    public RegistroResponseDTO cadastrarRegistro(RegistroRequestDTO dto){
        Cadastro cadastro = cadastroRepository.findById(dto.idCadt())
                .orElseThrow(() -> new RuntimeException("ERRO -> Cadastro" +
                        dto.idCadt() + " nao encontrado"));

        Registro novoRegistro = new Registro();

        novoRegistro.setCod(dto.cod());
        novoRegistro.setDescricao(dto.descricao());
        novoRegistro.setEstado(dto.estado());
        novoRegistro.setCadastro(cadastro);

        Registro registroSalvo = registroRepository.save(novoRegistro);
        return convertertoRespons(registroSalvo);
    }

    public List<RegistroResponseDTO> listarAllRegistros(){
       return registroRepository.findAll()
               .stream()
               .map(this::convertertoRespons)
               .toList();
    }

    public RegistroResponseDTO buscarRegistroPorId(Long idLog){
        Registro registro = registroRepository.findById(idLog)
                .orElseThrow(() -> new RuntimeException("ERRO" +
                        "Registro " +
                      idLog + "Nao encontrado!"));
        return convertertoRespons(registro);
    }

    public void deletarRegistro(Long idLog){
        Registro registro = registroRepository.findById(idLog)
                .orElseThrow(() -> new RuntimeException("ERRO" +
                        "Nao foi possivel deletar o Registro " +
                        idLog + "Nao encontrado!"));

        registroRepository.delete(registro);
    }

    public RegistroResponseDTO atualizarRegistro(Long idLog, RegistroRequestDTO dto){
        Cadastro cadastro = cadastroRepository.findById(dto.idCadt())
                .orElseThrow(() -> new RuntimeException(("ERRO" +
                        "Nao foi possivel atualizar" +
                        + dto.idCadt() +
                        "nao encontrado")));

        Registro registroAtualizado = registroRepository.findById(dto.idLog())
                .orElseThrow(() -> new RuntimeException(("ERRO" +
                        "Nao foi possivel atualizar" +
                        + dto.idLog() +
                        "nao encontrado")));

        registroAtualizado.setCod(dto.cod());
        registroAtualizado.setDescricao(dto.descricao());
        registroAtualizado.setEstado(dto.estado());
        registroAtualizado.setCadastro(cadastro);

        Registro registroAlterado = registroRepository.save(registroAtualizado);
        return convertertoRespons(registroAlterado);
    }
}
