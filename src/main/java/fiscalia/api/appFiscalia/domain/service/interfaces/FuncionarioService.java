package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.presentation.request.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {

  List<Funcionario> getAll();
  Funcionario getById(Integer id);
  Funcionario create(FuncionarioDto funcionario);
  Funcionario update(Integer id, FuncionarioDto funcionario);
  void delete(Integer id);

}
