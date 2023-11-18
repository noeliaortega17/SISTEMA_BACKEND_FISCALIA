package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Usuario;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

  public Usuario fromDto(UsuarioDto usuarioDto, Usuario usuarioFound) {
    Usuario usuario = new Usuario();

    if(usuarioFound != null){
      usuario = usuarioFound;
    }

    usuario.setUsuario(usuarioDto.getUsuario());
    usuario.setContrasena(usuarioDto.getContrasena());
    usuario.setIdFuncionario(usuarioDto.getIdFuncionario());

    return usuario;
  }

}
