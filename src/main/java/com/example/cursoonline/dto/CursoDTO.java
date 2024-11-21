package com.example.cursoonline.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CursoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
}