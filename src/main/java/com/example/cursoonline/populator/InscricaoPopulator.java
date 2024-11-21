package com.example.cursoonline.populator;

import com.example.cursoonline.dto.AlunoDTO;
import com.example.cursoonline.dto.CursoDTO;
import com.example.cursoonline.model.Aluno;
import com.example.cursoonline.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {

    public AlunoDTO populateAlunoDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public CursoDTO populateCursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }
}