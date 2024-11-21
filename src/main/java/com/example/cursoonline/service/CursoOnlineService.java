package com.example.cursoonline.service;

import com.example.cursoonline.dto.AlunoDTO;
import com.example.cursoonline.dto.CursoDTO;
import com.example.cursoonline.dto.InscricaoDTO;

import java.util.List;

public interface CursoOnlineService {
    AlunoDTO cadastrarAluno(AlunoDTO alunoDTO);
    CursoDTO cadastrarCurso(CursoDTO cursoDTO);
    InscricaoDTO inscreverAluno(Long alunoId, Long cursoId);
    List<CursoDTO> listarCursosDoAluno(Long alunoId);
    List<AlunoDTO> listarAlunosDoCurso(Long cursoId);
}