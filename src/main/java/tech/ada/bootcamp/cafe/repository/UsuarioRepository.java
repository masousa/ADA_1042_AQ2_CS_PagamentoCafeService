package tech.ada.bootcamp.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.bootcamp.cafe.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
