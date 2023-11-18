package et.clicket.api.appClicket.presentation.request.dto;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Persona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDto {
  private Integer id;
  private Persona idPersona;
  private Cargo idCargo;
}
