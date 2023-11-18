package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import java.util.List;

public interface FuncionarioService {

  List<Funcionario> getAll();
  Funcionario getById(Integer id);
  Funcionario create(FuncionarioDto funcionario);
  Funcionario update(Integer id, FuncionarioDto funcionario);
  void delete(Integer id);

}
