package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class RegistroObjecionDto {
  private Integer id;
  private TipoObjecion idTipoObjecion;
  private Funcionario idFuncionario;
  private int numeroResolucion;
  private Integer cud;
}
