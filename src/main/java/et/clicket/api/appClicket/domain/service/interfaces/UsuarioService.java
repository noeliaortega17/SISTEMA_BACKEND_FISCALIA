package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Usuario;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

  List<Usuario> getAll();
  Usuario getById(Integer id);
  Usuario create(UsuarioDto usuario);
  Usuario update(Integer id, UsuarioDto usuario );
  void delete(Integer id);

}
