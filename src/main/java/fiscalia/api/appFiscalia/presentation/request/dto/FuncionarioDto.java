package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Cargo;
import fiscalia.api.appFiscalia.domain.entity.Persona;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
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
  private Unidad idUnidad;
}
