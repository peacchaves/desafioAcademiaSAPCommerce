package com.example.cursoonline.service;

import com.example.cursoonline.dto.AlunoDTO;
import com.example.cursoonline.dto.CursoDTO;
import com.example.cursoonline.dto.InscricaoDTO;
import com.example.cursoonline.model.Aluno;
import com.example.cursoonline.model.Curso;
import com.example.cursoonline.model.Inscricao;
import com.example.cursoonline.populator.InscricaoPopulator;
import com.example.cursoonline.repository.AlunoRepository;
import com.example.cursoonline.repository.CursoRepository;
import com.example.cursoonline.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoOnlineServiceImpl implements CursoOnlineService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private InscricaoPopulator populator;

    @Override
    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setDataCadastro(LocalDate.now());
        aluno = alunoRepository.save(aluno);
        return populator.populateAlunoDTO(aluno);
    }

    @Override
    public CursoDTO cadastrarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCriacao(LocalDate.now());
        curso = cursoRepository.save(curso);
        return populator.populateCursoDTO(curso);
    }

    @Override
    public InscricaoDTO inscreverAluno(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(LocalDate.now());
        inscricao = inscricaoRepository.save(inscricao);

        InscricaoDTO dto = new InscricaoDTO();
        dto.setId(inscricao.getId());
        dto.setAlunoId(inscricao.getAluno().getId());
        dto.setCursoId(inscricao.getCurso().getId());
        dto.setDataInscricao(inscricao.getDataInscricao());
        return dto;
    }

    @Override
    public List<CursoDTO> listarCursosDoAluno(Long alunoId) {
        return inscricaoRepository.findByAlunoId(alunoId).stream()
                .map(i -> populator.populateCursoDTO(i.getCurso()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AlunoDTO> listarAlunosDoCurso(Long cursoId) {
        return inscricaoRepository.findByCursoId(cursoId).stream()
                .map(i -> populator.populateAlunoDTO(i.getAluno()))
                .collect(Collectors.toList());
    }
}