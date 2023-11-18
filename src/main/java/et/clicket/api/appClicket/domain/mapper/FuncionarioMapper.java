package et.clicket.api.appClicket.domain.mapper;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
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
