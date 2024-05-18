package edu.javeriana.ingenieria.social.matricula.controlador;

import edu.javeriana.ingenieria.social.matricula.dominio.Matricula;
import edu.javeriana.ingenieria.social.matricula.servicio.ServicioMatricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorMatricula {
    @Autowired
    private ServicioMatricula servicio;

    @GetMapping("listar")
    public List<Matricula> listar() {
        return servicio.obtenerMatriculas();
    }

    @GetMapping("obtener")
    public ResponseEntity<Matricula> obtenerMatricula(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.matriculaExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMatricula(id), HttpStatus.OK);
    }

    @GetMapping("obtenerSemestre")
    public ResponseEntity<List<Matricula>> obtenerMatricula(@RequestParam String semestre){
        if(semestre == null || semestre.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerMatriculaPorSemestre(semestre).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMatriculaPorSemestre(semestre), HttpStatus.OK);
    }

    @GetMapping("obtenerEstudiante")
    public ResponseEntity<List<Matricula>> obtenerMatriculaEstudiante(@RequestParam Integer estudiante){
        if(estudiante == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerMatriculasPorEstudiante(estudiante).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMatriculasPorEstudiante(estudiante), HttpStatus.OK);
    }

    @GetMapping("obtenerPrograma")
    public ResponseEntity<List<Matricula>> obtenerMatriculaPrograma(@RequestParam Integer programa){
        if(programa == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerMatriculasPorPrograma(programa).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerMatriculasPorPrograma(programa), HttpStatus.OK);
    }
}
