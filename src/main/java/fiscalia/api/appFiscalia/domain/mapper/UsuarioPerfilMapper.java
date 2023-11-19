package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioPerfilDto;
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
