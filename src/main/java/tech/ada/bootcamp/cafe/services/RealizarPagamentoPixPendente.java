package tech.ada.bootcamp.cafe.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.cafe.entidades.Pagamento;
import tech.ada.bootcamp.cafe.entidades.StatusCompra;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.cafe.repository.CompraRepository;
import tech.ada.bootcamp.cafe.repository.PagamentoRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RealizarPagamentoPixPendente {

    private final PagamentoRepository pagamentoRepository;
    private final CompraRepository compraRepository;

    public FormaPagamentoResponse execute(String chavePix) {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findByNumeroPix(chavePix);
        LocalDateTime dataAtual = LocalDateTime.now();
        FormaPagamentoResponse.FormaPagamentoResponseBuilder builder = FormaPagamentoResponse.builder();
        optionalPagamento.filter(pagamento -> ChronoUnit.MINUTES.between(dataAtual, pagamento.getDataCompra()) <= 30).ifPresent(pagamento -> {
            pagamento.getCompra().setStatus(StatusCompra.PAGO);
            pagamento.setCodigoTransacao(UUID.randomUUID().toString());
            pagamento.setDataPagamento(dataAtual);
            compraRepository.save(pagamento.getCompra());
            pagamentoRepository.save(pagamento);
            builder.statusCompra(pagamento.getCompra().getStatus())
                    .codigoTransacao(pagamento.getCodigoTransacao())
                    .numeroPix(pagamento.getNumeroPix())
                    .pendente(Objects.isNull(pagamento.getDataPagamento()))
                    .identificadorCompra(pagamento.getCompra().getIdentificador());
        });
        return builder.build();
    }
}
