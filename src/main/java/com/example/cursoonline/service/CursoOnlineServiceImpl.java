package com.example.cursoonline.service;

import com.example.cursoonline.dto.AlunoDTO;
import com.example.cursoonline.dto.CursoDTO;
import com.example.cursoonline.dto.InscricaoDTO;
import com.example.cursoonline.model.Aluno;
import com.example.cursoonline.model.Curso;
import com.example.cursoonline.model.Inscricao;
import com.example.cursoonline.populator.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CursoOnlineServiceImpl implements CursoOnlineService {

    private final Map<Long, Aluno> alunos = new HashMap<>();
    private final Map<Long, Curso> cursos = new HashMap<>();
    private final Map<Long, Inscricao> inscricoes = new HashMap<>();
    private Long nextAlunoId = 1L;
    private Long nextCursoId = 1L;
    private Long nextInscricaoId = 1L;

    @Autowired
    private InscricaoPopulator populator;

    @Override
    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(nextAlunoId++);
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setDataCadastro(LocalDate.now());
        alunos.put(aluno.getId(), aluno);
        return populator.populateAlunoDTO(aluno);
    }

    @Override
    public CursoDTO cadastrarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(nextCursoId++);
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCriacao(LocalDate.now());
        cursos.put(curso.getId(), curso);
        return populator.populateCursoDTO(curso);
    }

    @Override
    public InscricaoDTO inscreverAluno(Long alunoId, Long cursoId) {
        if (!alunos.containsKey(alunoId) || !cursos.containsKey(cursoId)) {
            throw new RuntimeException("Aluno ou curso não encontrado");
        }
        Inscricao inscricao = new Inscricao();
        inscricao.setId(nextInscricaoId++);
        inscricao.setAlunoId(alunoId);
        inscricao.setCursoId(cursoId);
        inscricao.setDataInscricao(LocalDate.now());
        inscricoes.put(inscricao.getId(), inscricao);

        InscricaoDTO dto = new InscricaoDTO();
        dto.setId(inscricao.getId());
        dto.setAlunoId(inscricao.getAlunoId());
        dto.setCursoId(inscricao.getCursoId());
        dto.setDataInscricao(inscricao.getDataInscricao());
        return dto;
    }

    @Override
    public List<CursoDTO> listarCursosDoAluno(Long alunoId) {
        return inscricoes.values().stream()
                .filter(i -> i.getAlunoId().equals(alunoId))
                .map(i -> cursos.get(i.getCursoId()))
                .map(populator::populateCursoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlunoDTO> listarAlunosDoCurso(Long cursoId) {
        return inscricoes.values().stream()
                .filter(i -> i.getCursoId().equals(cursoId))
                .map(i -> alunos.get(i.getAlunoId()))
                .map(populator::populateAlunoDTO)
                .collect(Collectors.toList());
    }
}