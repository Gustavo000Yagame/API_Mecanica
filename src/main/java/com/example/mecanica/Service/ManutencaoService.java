package com.example.mecanica.Service;

import com.example.mecanica.dto.ManutencaoRequestDTO;
import com.example.mecanica.dto.ManutencaoResponseDTO;
import com.example.mecanica.model.Cadastro;
import com.example.mecanica.model.Manutencao;
import com.example.mecanica.model.Registro;
import com.example.mecanica.repository.CadastroRepository;
import com.example.mecanica.repository.ManutencaoRepositoy;
import com.example.mecanica.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManutencaoService {

    private final RegistroRepository registroRepository;
    private final CadastroRepository cadastroRepository;
    private final ManutencaoRepositoy manutencaoRepositoy;

    private ManutencaoResponseDTO convertToRespons(Manutencao manutencao){
        return new ManutencaoResponseDTO(

                manutencao.getIdManu(),
                manutencao.getDescricao(),
                manutencao.getValor(),
                manutencao.getDataManutencao(),
                manutencao.getEstado(),
                manutencao.getCadastro().getIdCadastro(),
                manutencao.getRegistro().getIdLog()
        );
    }

    public ManutencaoResponseDTO casdastroDeManutencao(ManutencaoRequestDTO dto){
        Registro registro = registroRepository.findById(dto.idDoregistro())
                .orElseThrow(() -> new RuntimeException("Registro " +
                        dto.idDoregistro() + "nao encontrado " ));

        Cadastro cadastro = cadastroRepository.findById(dto.idDocadastro())
                .orElseThrow(() -> new RuntimeException("Cadastro " +
                        dto.idDocadastro() + "nao encontrado " ));

        Manutencao manutencao = new Manutencao();
                manutencao.setDescricao(dto.descricao());
                manutencao.setValor(dto.valor());
                manutencao.setDataManutencao(dto.dataManutencao());
                manutencao.setEstado(dto.estado());
                manutencao.setCadastro(cadastro);
                manutencao.setRegistro(registro);

        Manutencao cadManu = manutencaoRepositoy.save(manutencao);
        return convertToRespons(cadManu);
    }

    public ManutencaoResponseDTO attManutecao(Long idManu, ManutencaoRequestDTO dto){
        Registro registro = registroRepository.findById(dto.idDoregistro())
                .orElseThrow(() -> new RuntimeException("Registro " +
                        dto.idDoregistro() + "nao encontrado " ));

        Cadastro cadastro = cadastroRepository.findById(dto.idDocadastro())
                .orElseThrow(() -> new RuntimeException("Cadastro " +
                        dto.idDocadastro() + "nao encontrado " ));

        Manutencao manutencao = manutencaoRepositoy.findById((idManu))
                .orElseThrow(() -> new RuntimeException("Manutencao " +
                        idManu + "nao encontrado " ));

        manutencao.setDescricao(dto.descricao());
        manutencao.setValor(dto.valor());
        manutencao.setDataManutencao(dto.dataManutencao());
        manutencao.setEstado(dto.estado());
        manutencao.setCadastro(cadastro);
        manutencao.setRegistro(registro);

        Manutencao savarnova = manutencaoRepositoy.save(manutencao);
        return convertToRespons(savarnova);
    }
}
