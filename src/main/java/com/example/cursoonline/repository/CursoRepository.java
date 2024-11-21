@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}

// InscricaoRepository.java
@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByAlunoId(Long alunoId);
    List<Inscricao> findByCursoId(Long cursoId);
}