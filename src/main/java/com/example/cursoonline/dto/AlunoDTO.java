package com.example.cursoonline.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;
}