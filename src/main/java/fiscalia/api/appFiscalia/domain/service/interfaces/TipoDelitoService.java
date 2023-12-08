package fiscalia.api.appFiscalia.domain.service.interfaces;


import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoDelitoDto;

import java.util.List;

public interface TipoDelitoService {

  List<TipoDelito> getAll();
  TipoDelito getById(Integer id);
  TipoDelito create(TipoDelitoDto tipoDelito);
  TipoDelito update(Integer id, TipoDelitoDto tipoDelito);
  void delete(Integer id);

}
