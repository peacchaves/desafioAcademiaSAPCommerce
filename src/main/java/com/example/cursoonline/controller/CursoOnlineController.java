package com.example.cursoonline.controller;

import com.example.cursoonline.dto.AlunoDTO;
import com.example.cursoonline.dto.CursoDTO;
import com.example.cursoonline.dto.InscricaoDTO;
import com.example.cursoonline.service.CursoOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoOnlineController {

    @Autowired
    private CursoOnlineService service;

    @PostMapping("/alunos")
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok(service.cadastrarAluno(alunoDTO));
    }

    @PostMapping("/cursos")
    public ResponseEntity<CursoDTO> cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(service.cadastrarCurso(cursoDTO));
    }

    @PostMapping("/inscricoes")
    public ResponseEntity<InscricaoDTO> inscreverAluno(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        return ResponseEntity.ok(service.inscreverAluno(alunoId, cursoId));
    }

    @GetMapping("/alunos/{alunoId}/cursos")
    public ResponseEntity<List<CursoDTO>> listarCursosDoAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.listarCursosDoAluno(alunoId));
    }

    @GetMapping("/cursos/{cursoId}/alunos")
    public ResponseEntity<List<AlunoDTO>> listarAlunosDoCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.listarAlunosDoCurso(cursoId));
    }
}