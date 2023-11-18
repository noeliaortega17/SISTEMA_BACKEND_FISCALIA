package et.clicket.api.appClicket.presentation.request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDto {
  private Integer id;
  private String nombre;
  private String apellidoPat;
  private String apellidoMat;
  private String ci;
  private int celular;
}
