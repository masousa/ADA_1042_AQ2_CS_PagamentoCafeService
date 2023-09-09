package tech.ada.bootcamp.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.bootcamp.cafe.entidades.Pagamento;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
   Optional<Pagamento> findByCompraIdentificador(String compraId);

   Optional<Pagamento> findByNumeroPix(String chavePix);
}
