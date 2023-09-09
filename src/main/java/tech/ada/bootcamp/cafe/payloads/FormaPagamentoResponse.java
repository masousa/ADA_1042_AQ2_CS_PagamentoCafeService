package tech.ada.bootcamp.cafe.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import tech.ada.bootcamp.cafe.entidades.StatusCompra;

import java.io.Serializable;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormaPagamentoResponse implements Serializable {

    private String numeroPix;
    private String codigoTransacao;
    private boolean pendente;
    private StatusCompra statusCompra;
    private String identificadorCompra;

}
