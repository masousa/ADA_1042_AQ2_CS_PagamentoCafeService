package tech.ada.bootcamp.cafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoRequest;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.cafe.services.PagamentoService;

@RestController
@RequestMapping(name = "/pagamento")
@RequiredArgsConstructor
public class PagamentoController {
    private final PagamentoService pagamentoService;
    @PostMapping(value = "/")
    public FormaPagamentoResponse realizarPagamento (@RequestBody FormaPagamentoRequest request){
        return pagamentoService.execute(request);
    }
}
