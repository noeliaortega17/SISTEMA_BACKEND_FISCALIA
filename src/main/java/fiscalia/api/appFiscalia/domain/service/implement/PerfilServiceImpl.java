package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.PerfilRepository;
import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.mapper.PerfilMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.PerfilService;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PerfilServiceImpl implements PerfilService {

  private final PerfilRepository perfilRepository;
  private final PerfilMapper perfilMapper;

  @Override
  public List<Perfil> getAll() {
    return perfilRepository.findAllByActivo(true);
  }

  @Override
  public Perfil getById(Integer id) {
    Perfil perfil = perfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Perfil", id));
    return perfil;
  }

  @Override
  public Perfil create(PerfilDto perfilDto) {
    Perfil perfil = perfilMapper.fromDto(perfilDto, null);
    return perfilRepository.save(perfil);
  }

  @Override
  public Perfil update(Integer id, PerfilDto perfilDto) {
    Perfil perfilFound = perfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Perfil", id));
    Perfil perfil = perfilMapper.fromDto(perfilDto, perfilFound);
    return perfilRepository.save(perfil);
  }

  @Override
  public void delete(Integer id) {
    Perfil perfilFound = perfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Perfil", id));
    perfilFound.setActivo(false);
    perfilFound.setFecha_eliminacion(LocalDateTime.now());
    perfilRepository.save(perfilFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
