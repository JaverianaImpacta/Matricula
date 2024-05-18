package edu.javeriana.ingenieria.social.matricula.repositorio;

import edu.javeriana.ingenieria.social.matricula.dominio.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMatricula extends JpaRepository<Matricula, Integer> {
    List<Matricula> findAllByEstudiante(Integer estudiante);

    List<Matricula> findAllByPrograma(Integer programa);

    List<Matricula> findAllBySemestre(String semestre);
}
