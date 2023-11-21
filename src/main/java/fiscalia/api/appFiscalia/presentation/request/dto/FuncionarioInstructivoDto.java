package fiscalia.api.appFiscalia.presentation.request.dto;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.Instructivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioInstructivoDto {
  private Integer id;
  private Funcionario idFuncionario;
  private Instructivo idInstructivo;
}
