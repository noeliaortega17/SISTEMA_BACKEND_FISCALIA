package fiscalia.api.appFiscalia.domain.service.interfaces;


import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioInstructivoDto;

import java.util.List;

public interface FuncionarioInstructivoService {

  List<FuncionarioInstructivo> getAll();
  FuncionarioInstructivo getById(Integer id);
  FuncionarioInstructivo create(FuncionarioInstructivoDto funcionarioInstructivo);
  FuncionarioInstructivo update(Integer id, FuncionarioInstructivoDto funcionarioInstructivo);
  void delete(Integer id);

}
