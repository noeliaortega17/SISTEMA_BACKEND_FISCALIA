package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.PersonaRepository;
import fiscalia.api.appFiscalia.domain.entity.Persona;
import fiscalia.api.appFiscalia.domain.mapper.PersonaMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.PersonaService;
import fiscalia.api.appFiscalia.presentation.request.dto.PersonaDto;
import fiscalia.api.exception.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {

  private final PersonaRepository personaRepository;
  private final PersonaMapper personaMapper;

  @Override
  public List<Persona> getAll() {

    return personaRepository.findAllByActivo(true);
  }

  @Override
  public Persona getById(Integer id) {
    Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Persona", id));
    return persona;
  }

  @Override
  public Persona create(PersonaDto personaDto) {
    Persona persona = personaMapper.fromDto(personaDto, null);
    return personaRepository.save(persona);
  }

  @Override
  public Persona update(Integer id, PersonaDto personaDto) {
    Persona personaFound = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Persona", id));
    Persona persona = personaMapper.fromDto(personaDto, personaFound);
    return personaRepository.save(persona);
  }

  @Override
  public void delete(Integer id) {
    Persona personaFound = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Persona", id));
    personaFound.setActivo(false);
    personaRepository.save(personaFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
