package et.clicket.api.appClicket.presentation.request.dto;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Perfil;
import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.domain.entity.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioPerfilDto {
  private Integer id;
  private Usuario idUsuario;
  private Perfil idPerfil;
}
