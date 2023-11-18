package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.UsuarioPerfil;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioPerfilDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPerfilMapper {

  public UsuarioPerfil fromDto(UsuarioPerfilDto usuarioPerfilDto, UsuarioPerfil usuarioPerfilFound) {
    UsuarioPerfil usuarioPerfil = new UsuarioPerfil();

    if(usuarioPerfilFound != null){
      usuarioPerfil = usuarioPerfilFound;
    }

    usuarioPerfil.setIdUsuario(usuarioPerfilDto.getIdUsuario());
    usuarioPerfil.setIdPerfil(usuarioPerfilDto.getIdPerfil());

    return usuarioPerfil;
  }

}
