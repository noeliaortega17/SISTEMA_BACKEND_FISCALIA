package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Usuario;
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
