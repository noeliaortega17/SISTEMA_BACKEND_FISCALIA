package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginResponse;
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
