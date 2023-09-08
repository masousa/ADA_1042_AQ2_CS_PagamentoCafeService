package tech.ada.bootcamp.cafe.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    private TipoPagamento tipoPagamento;

    @Column(name = "numero_cartao")
    private String numeroCartao;

    private String cvv;
    @Column(name = "nome_titular")
    private String nomeTitular;

    @Column(name = "numero_pix")
    private String numeroPix;

    @Column(name = "codigo_transacao")
    private String codigoTransacao;

}
