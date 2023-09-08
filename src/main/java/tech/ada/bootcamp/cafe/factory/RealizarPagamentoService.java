package tech.ada.bootcamp.cafe.factory;

import tech.ada.bootcamp.cafe.entidades.Compra;
import tech.ada.bootcamp.cafe.entidades.Pagamento;
import tech.ada.bootcamp.cafe.entidades.TipoPagamento;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;

import java.time.LocalDateTime;

public interface RealizarPagamentoService {
    TipoPagamento getTipoPagamento();
    Pagamento realizarPagamento(Compra compra);

    default Pagamento generateDefaultPagamento(Compra compra){
        Pagamento pagamento = new Pagamento();
        pagamento.setDataCompra(LocalDateTime.now());
        pagamento.setCompra(compra);
        pagamento.setTipoPagamento(getTipoPagamento());
        pagamento.setNomeTitular(compra.getUsuario().getNome());
        return pagamento;
    }
}
