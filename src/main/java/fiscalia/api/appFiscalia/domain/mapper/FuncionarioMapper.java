package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

  public Funcionario fromDto(FuncionarioDto funcionarioDto, Funcionario funcionarioFound) {
    Funcionario funcionario = new Funcionario();

    if(funcionarioFound != null){
      funcionario = funcionarioFound;
    }

    funcionario.setIdPersona(funcionarioDto.getIdPersona());
    funcionario.setIdCargo(funcionarioDto.getIdCargo());

    return funcionario;
  }

}
