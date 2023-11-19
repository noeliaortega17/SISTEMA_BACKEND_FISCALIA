package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioPerfilDto;

import java.util.List;

public interface UsuarioPerfilService {

  List<UsuarioPerfil> getAll();
  UsuarioPerfil getById(Integer id);
  UsuarioPerfil create(UsuarioPerfilDto usuarioPerfil);
  UsuarioPerfil update(Integer id, UsuarioPerfilDto usuarioPerfil);
  void delete(Integer id);

}
