package com.example.cursoonline.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Curso {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
}

// Inscricao.java
package com.example.cursoonline.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Inscricao {
    private Long id;
    private Long alunoId;
    private Long cursoId;
    private LocalDate dataInscricao;
}