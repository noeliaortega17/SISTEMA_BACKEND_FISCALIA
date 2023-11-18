package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.PersonaRepository;
import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.domain.mapper.PersonaMapper;
import et.clicket.api.appClicket.domain.service.interfaces.PersonaService;
import et.clicket.api.appClicket.presentation.request.dto.PersonaDto;
import et.clicket.api.exception.EntityNotFoundException;
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
