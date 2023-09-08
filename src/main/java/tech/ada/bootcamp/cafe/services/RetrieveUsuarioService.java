package tech.ada.bootcamp.cafe.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.cafe.entidades.Usuario;
import tech.ada.bootcamp.cafe.payloads.FormaPagamentoRequest;
import tech.ada.bootcamp.cafe.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class RetrieveUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario execute(FormaPagamentoRequest formaPagamentoRequest){
        Usuario usuario = new Usuario();
        usuario.setIdentificador(formaPagamentoRequest.getIdentificadorUsuario());
        usuario.setNome(formaPagamentoRequest.getNomeTitular());
        return usuarioRepository.findById(formaPagamentoRequest.getIdentificadorUsuario())
                .orElse(usuarioRepository.save(usuario));
    }
}
