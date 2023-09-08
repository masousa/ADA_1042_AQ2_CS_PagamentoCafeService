package tech.ada.bootcamp.cafe.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    private StatusCompra status;

    @Column(name = "valor_cobrado")
    private double valorCobrado;

    private double desconto;

    @ManyToOne
    @JoinColumn(name = "usuario_identificador")
    private Usuario usuario;

    private String identificador;

}
