package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;

import java.util.List;

public interface PerfilService {

  List<Perfil> getAll();
  Perfil getById(Integer id);
  Perfil create(PerfilDto perfil);
  Perfil update(Integer id, PerfilDto perfil);
  void delete(Integer id);

}
