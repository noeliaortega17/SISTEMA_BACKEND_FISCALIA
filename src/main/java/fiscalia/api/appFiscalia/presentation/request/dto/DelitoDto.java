package fiscalia.api.appFiscalia.presentation.request.dto;


import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DelitoDto {
  private Integer id;
  private String descripcion;
  private TipoDelito idTipoDelito;
}
