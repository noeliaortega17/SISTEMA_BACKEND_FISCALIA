package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import fiscalia.api.appFiscalia.presentation.request.dto.InstructivoDto;

import java.util.List;

public interface InstructivoService {

  List<Instructivo> getAll();
  Instructivo getById(Integer id);
  Instructivo create(InstructivoDto instructivo);
  Instructivo update(Integer id, InstructivoDto instructivo);
  void delete(Integer id);

}
