package fiscalia.api.appFiscalia.domain.service.interfaces;

import fiscalia.api.appFiscalia.domain.entity.Persona;
import fiscalia.api.appFiscalia.presentation.request.dto.PersonaDto;
import java.util.List;

public interface PersonaService {

  List<Persona> getAll();
  Persona getById(Integer id);
  Persona create(PersonaDto persona);
  Persona update(Integer id, PersonaDto persona);
  void delete(Integer id);

}
