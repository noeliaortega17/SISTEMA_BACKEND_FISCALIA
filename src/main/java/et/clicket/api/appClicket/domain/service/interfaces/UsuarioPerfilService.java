package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.UsuarioPerfil;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioPerfilDto;

import java.util.List;

public interface UsuarioPerfilService {

  List<UsuarioPerfil> getAll();
  UsuarioPerfil getById(Integer id);
  UsuarioPerfil create(UsuarioPerfilDto usuarioPerfil);
  UsuarioPerfil update(Integer id, UsuarioPerfilDto usuarioPerfil);
  void delete(Integer id);

}
