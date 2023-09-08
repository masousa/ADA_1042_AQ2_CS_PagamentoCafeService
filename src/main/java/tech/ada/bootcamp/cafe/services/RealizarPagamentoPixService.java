package tech.ada.bootcamp.cafe.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import tech.ada.bootcamp.cafe.entidades.Compra;
import tech.ada.bootcamp.cafe.entidades.Pagamento;
import tech.ada.bootcamp.cafe.entidades.StatusCompra;
import tech.ada.bootcamp.cafe.entidades.TipoPagamento;
import tech.ada.bootcamp.cafe.factory.RealizarPagamentoService;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RealizarPagamentoPixService implements RealizarPagamentoService {

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.PIX;
    }

    @Override
    public Pagamento realizarPagamento(Compra compra) {
        compra.setStatus(StatusCompra.PENDENTE);
        return  generateDefaultPagamento(compra);
    }
}
