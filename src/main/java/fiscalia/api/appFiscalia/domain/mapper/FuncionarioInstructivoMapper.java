package fiscalia.api.appFiscalia.domain.mapper;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioInstructivoMapper {

  public FuncionarioInstructivo fromDto(FuncionarioInstructivoDto funcionarioInstructivoDto, FuncionarioInstructivo funcionarioInstructivoFound) {
    FuncionarioInstructivo funcionarioInstructivo = new FuncionarioInstructivo();

    if(funcionarioInstructivoFound != null){
      funcionarioInstructivo = funcionarioInstructivoFound;
    }

    funcionarioInstructivo.setIdFuncionario(funcionarioInstructivoDto.getIdFuncionario());
    funcionarioInstructivo.setIdInstructivo(funcionarioInstructivoDto.getIdInstructivo());

    return funcionarioInstructivo;
  }

}
