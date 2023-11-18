package et.clicket.api.appClicket.presentation.request.dto;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Persona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {
  private Integer id;
  private Integer usuario;
  private String contrasena;
  private Funcionario idFuncionario;

}
