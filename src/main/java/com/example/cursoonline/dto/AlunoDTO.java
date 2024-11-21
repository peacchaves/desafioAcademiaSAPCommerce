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

// CursoDTO.java
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

// InscricaoDTO.java
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
```

Etapa 4: Criação do Populator

Crie a seguinte classe no pacote `populator`:

```java
// InscricaoPopulator.java
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