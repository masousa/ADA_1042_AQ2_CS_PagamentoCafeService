package tech.ada.bootcamp.cafe.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.cafe.entidades.Pagamento;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.cafe.repository.PagamentoRepository;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultarPagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public FormaPagamentoResponse execute(String compraId){
        FormaPagamentoResponse.FormaPagamentoResponseBuilder builder = FormaPagamentoResponse.builder();
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findByCompraIdentificador(compraId);
        if(optionalPagamento.isPresent()){
            Pagamento pagamento = optionalPagamento.get();
            builder.statusCompra(pagamento.getCompra().getStatus())
                    .codigoTransacao(pagamento.getCodigoTransacao())
                    .numeroPix(pagamento.getNumeroPix())
                    .pendente(Objects.isNull(pagamento.getDataPagamento()))
                    .identificadorCompra(pagamento.getCompra().getIdentificador());
        }

        return builder.build();
    }
}
