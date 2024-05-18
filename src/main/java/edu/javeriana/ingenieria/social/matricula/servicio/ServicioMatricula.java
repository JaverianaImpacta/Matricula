package edu.javeriana.ingenieria.social.matricula.servicio;

import edu.javeriana.ingenieria.social.matricula.dominio.Matricula;
import edu.javeriana.ingenieria.social.matricula.repositorio.RepositorioMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMatricula {
    @Autowired
    private RepositorioMatricula repositorio;

    public List<Matricula> obtenerMatriculas() {
        return repositorio.findAll();
    }

    public List<Matricula> obtenerMatriculasPorEstudiante(Integer estudiante) {
        return repositorio.findAllByEstudiante(estudiante);
    }

    public List<Matricula> obtenerMatriculasPorPrograma(Integer programa) {
        return repositorio.findAllByPrograma(programa);
    }

    public List<Matricula> obtenerMatriculaPorSemestre(String semestre){
        return repositorio.findAllBySemestre(semestre);
    }

    public Matricula obtenerMatricula(Integer id) {
        return repositorio.findById(id).orElse(null);
    }
    public boolean matriculaExiste(Integer id){
        return repositorio.existsById(id);
    }
}
