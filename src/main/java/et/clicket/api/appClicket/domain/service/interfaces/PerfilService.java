package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Perfil;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import et.clicket.api.appClicket.presentation.request.dto.PerfilDto;

import java.util.List;

public interface PerfilService {

  List<Perfil> getAll();
  Perfil getById(Integer id);
  Perfil create(PerfilDto perfil);
  Perfil update(Integer id, PerfilDto perfil);
  void delete(Integer id);

}
