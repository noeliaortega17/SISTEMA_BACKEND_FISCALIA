package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Delito;
import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DesarchivoDto {
  private Integer id;

  private Integer cud;

  private String motivo;

  public LocalDateTime fechaDesarchivo;

  public LocalDateTime fechaAsignacion;

  public LocalDateTime fechaRecepcion;

  private Funcionario idFuncionario;
  private Delito idDelito;
}
