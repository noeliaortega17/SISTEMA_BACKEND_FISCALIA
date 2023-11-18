package et.clicket.api.appClicket.presentation.request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InstructivoDto {
  private Integer id;
  private Integer cite;
  private String descripcion;
  private Boolean fiscaliaGeneral;
  @CreationTimestamp
  public LocalDateTime fecha_instructivo;

}
