package tech.ada.bootcamp.cafe.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    private String nome;
    @Id
    private String identificador;
}
