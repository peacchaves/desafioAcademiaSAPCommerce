package com.example.cursoonline.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Aluno {
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;
}

// Curso.java
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