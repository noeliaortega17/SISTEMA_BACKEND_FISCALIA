package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Instructivo;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.InstructivoDto;

import java.util.List;

public interface InstructivoService {

  List<Instructivo> getAll();
  Instructivo getById(Integer id);
  Instructivo create(InstructivoDto instructivo);
  Instructivo update(Integer id, InstructivoDto instructivo);
  void delete(Integer id);

}
