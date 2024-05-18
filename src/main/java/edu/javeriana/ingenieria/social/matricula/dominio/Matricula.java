package edu.javeriana.ingenieria.social.matricula.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Matricula {
    @Id
    private Integer id;
    private Integer estudiante, programa;
    private String semestre;
}
