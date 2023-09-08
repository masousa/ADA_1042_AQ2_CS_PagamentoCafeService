package tech.ada.bootcamp.cafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoRequest;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoResponse;
import tech.ada.bootcamp.cafe.services.ConsultarPagamentoService;
import tech.ada.bootcamp.cafe.services.PagamentoService;
import tech.ada.bootcamp.cafe.services.RealizarPagamentoPixPendente;

@RestController
@RequestMapping(name = "/pagamento")
@RequiredArgsConstructor
public class PagamentoController {
    private final PagamentoService pagamentoService;
    public final ConsultarPagamentoService consultarPagamentoService;
    public final RealizarPagamentoPixPendente realizarPagamentoPixPendente;
    @PostMapping(value = "/")
    public FormaPagamentoResponse realizarPagamento (@RequestBody FormaPagamentoRequest request){
        return pagamentoService.execute(request);
    }

    @GetMapping(value = "/{idCompra}")
    public FormaPagamentoResponse consultarPagamentoPorCompra(@PathVariable String idCompra){
        return consultarPagamentoService.execute(idCompra);
    }

    @PatchMapping(value = "/{chavePix}")
    public FormaPagamentoResponse realizarPagamentoPendente(@PathVariable String chavePix){
        return realizarPagamentoPixPendente.execute(chavePix);
    }
}
