package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Delito;
import fiscalia.api.appFiscalia.presentation.request.dto.DelitoDto;

import java.util.List;

public interface DelitoService {

  List<Delito> getAll();
  Delito getById(Integer id);
  Delito create(DelitoDto delito);
  Delito update(Integer id, DelitoDto delito);
  void delete(Integer id);

}
