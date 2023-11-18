package et.clicket.api.appClicket.domain.service.interfaces;

import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.presentation.request.dto.PersonaDto;
import java.util.List;

public interface PersonaService {

  List<Persona> getAll();
  Persona getById(Integer id);
  Persona create(PersonaDto persona);
  Persona update(Integer id, PersonaDto persona);
  void delete(Integer id);

}
