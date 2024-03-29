package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioDto;

import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginRequest;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginResponse;
import java.util.List;

public interface UsuarioService {

  List<Usuario> getAll();
  Usuario getById(Integer id);
  Usuario create(UsuarioDto usuario);
  Usuario update(Integer id, UsuarioDto usuario );
  void delete(Integer id);

  UsuarioLoginResponse login(UsuarioLoginRequest usuarioLogin);

}
