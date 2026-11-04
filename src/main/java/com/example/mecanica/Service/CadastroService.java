package com.example.mecanica.Service;

import com.example.mecanica.dto.CadastroRequestDTO;
import com.example.mecanica.dto.CadastroResponseDTO;
import com.example.mecanica.model.Cadastro;
import com.example.mecanica.repository.CadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    private CadastroResponseDTO converterParaRespos(Cadastro cadastro) {
        return new CadastroResponseDTO(
                cadastro.getIdCadastro(),
                cadastro.getTipoVeiculo(),
                cadastro.getModelo(),
                cadastro.getEstado(),
                cadastro.getDataDecadastro()
        );
    }

    public CadastroResponseDTO cadastroVeiculo(CadastroRequestDTO dto) {
        Cadastro cadastro = new Cadastro();

        cadastro.setTipoVeiculo(dto.tipoVeiculo());
        cadastro.setModelo(dto.modelo());
        cadastro.setEstado(dto.estado());
        cadastro.setDataDecadastro(dto.dataDecadastro());

        Cadastro cadastrado = cadastroRepository.save(cadastro);
        return converterParaRespos(cadastrado);
    }

    public void deletarCadastro(Long idCadastro) {
        Cadastro cadastroEncontrado = cadastroRepository.findById(idCadastro)
                .orElseThrow(() -> new RuntimeException
                        ("Cadastro não encontrado" + idCadastro));

        cadastroRepository.delete(cadastroEncontrado);
    }

    public List<CadastroResponseDTO> listarALL(){
        return cadastroRepository.findAll()
                .stream()
                .map(this::converterParaRespos)
                .toList();
    }

    public CadastroResponseDTO buscarCadPorId(long idCadastro){
        Cadastro cadastroBuscadoID = cadastroRepository.findById(idCadastro)
                .orElseThrow(() -> new RuntimeException("Cadastro não encontrado"));

        return converterParaRespos(cadastroBuscadoID);
    }

    public CadastroResponseDTO attCadastros(Long idCadastro, CadastroRequestDTO dto){
        Cadastro cadastro = cadastroRepository.findById(idCadastro)
                .orElseThrow(()
                -> new RuntimeException("->" +
                        "ERRO:" +
                        "Cadastro não encotrado" +
                        "Não foi possivel atualizar!!"));

        cadastro.setTipoVeiculo(dto.tipoVeiculo());
        cadastro.setModelo(dto.modelo());
        cadastro.setEstado(dto.estado());
        cadastro.setDataDecadastro(dto.dataDecadastro());

        Cadastro novoCadastro = cadastroRepository.save(cadastro);
        return converterParaRespos(novoCadastro);
    }
}
