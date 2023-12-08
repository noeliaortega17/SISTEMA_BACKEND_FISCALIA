package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.RegistroObjecion;
import fiscalia.api.appFiscalia.presentation.request.dto.RegistroObjecionDto;
import java.util.List;

public interface RegistroObjecionService {

  List<RegistroObjecion> getAll();
  RegistroObjecion getById(Integer id);
  RegistroObjecion create(RegistroObjecionDto registroObjecion);
  RegistroObjecion update(Integer id, RegistroObjecionDto registroObjecion);
  void delete(Integer id);

}
