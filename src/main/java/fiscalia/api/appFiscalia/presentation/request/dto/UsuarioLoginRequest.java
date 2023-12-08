package fiscalia.api.appFiscalia.presentation.request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioLoginRequest {

  private String user;
  private String password;

}
