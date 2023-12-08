package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {
  private Integer id;
  private String usuario;
  private String contrasena;
  private Funcionario idFuncionario;

}
