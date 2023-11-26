package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UnidadDto;

import java.util.List;

public interface UnidadService {

  List<Unidad> getAll();
  Unidad getById(Integer id);
  Unidad create(UnidadDto unidad);
  Unidad update(Integer id, UnidadDto unidad);
  void delete(Integer id);

}
