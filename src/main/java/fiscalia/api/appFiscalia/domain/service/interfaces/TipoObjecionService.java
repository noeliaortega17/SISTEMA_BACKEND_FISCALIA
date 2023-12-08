package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoObjecionDto;

import java.util.List;

public interface TipoObjecionService {

  List<TipoObjecion> getAll();
  TipoObjecion getById(Integer id);
  TipoObjecion create(TipoObjecionDto tipoObjecion);
  TipoObjecion update(Integer id, TipoObjecionDto tipoObjecion);
  void delete(Integer id);

}
