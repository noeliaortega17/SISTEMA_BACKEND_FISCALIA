package fiscalia.api.appFiscalia.presentation.request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InstructivoDto {
  private Integer id;
  private Integer cite;
  private String descripcion;
  private Boolean fiscaliaGeneral;
  public LocalDateTime fechaInstructivo;
  private String pdf;

}
