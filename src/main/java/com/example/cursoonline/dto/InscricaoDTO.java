package com.example.cursoonline.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InscricaoDTO {
    private Long id;
    private Long alunoId;
    private Long cursoId;
    private LocalDate dataInscricao;
}