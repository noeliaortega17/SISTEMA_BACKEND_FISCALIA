package et.clicket.api.appClicket.presentation.request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CargoDto {
  private Integer id;
  private String descripcion;
  private Integer item;
}
