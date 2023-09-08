package tech.ada.bootcamp.cafe.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.cafe.entidades.Compra;
import tech.ada.bootcamp.cafe.entidades.Pagamento;
import tech.ada.bootcamp.cafe.factory.RealizarPagamentoFactory;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoRequest;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.cafe.repository.CompraRepository;
import tech.ada.bootcamp.cafe.repository.PagamentoRepository;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoService {

    private final RealizarPagamentoFactory realizarPagamentoFactory;
    private final RetrieveUsuarioService retrieveUsuarioService;
    private final CompraRepository compraRepository;
    private final PagamentoRepository pagamentoRepository;

    public FormaPagamentoResponse execute(FormaPagamentoRequest request){
        tech.ada.bootcamp.cafe.factory.RealizarPagamentoService service = realizarPagamentoFactory
                .getFormaPagamento(request.getTipoPagamento());
        Compra compra = new Compra();
        compra.setDataCompra(LocalDateTime.now());
        compra.setValorCobrado(request.getValor());
        compra.setDesconto(request.getDesconto());
        compra.setUsuario(retrieveUsuarioService.execute(request));
        log.info("Detalhes da compra {}", compra);
        Pagamento pagamento = service.realizarPagamento(compraRepository.save(compra));
        log.info("Detalhes do pagamento {}", pagamento);
       return formatarPagamentoResponse(pagamentoRepository.save(pagamento));

    }

    private FormaPagamentoResponse formatarPagamentoResponse(Pagamento pagamento) {
        return FormaPagamentoResponse.builder()
                .codigoTransacao(pagamento.getCodigoTransacao())
                .numeroPix(pagamento.getNumeroPix())
                .pendente(Objects.isNull(pagamento.getDataPagamento()))
                .statusCompra(pagamento.getCompra().getStatus())
                .build();
    }
}
