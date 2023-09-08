package tech.ada.bootcamp.cafe.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tech.ada.bootcamp.cafe.entidades.TipoPagamento;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoRequest {

    private TipoPagamento tipoPagamento;
    private String numeroCartao;
    private String cvv;
    private String nomeTitular;
    private double valor;
    private double desconto;
    private String identificadorUsuario;

}
