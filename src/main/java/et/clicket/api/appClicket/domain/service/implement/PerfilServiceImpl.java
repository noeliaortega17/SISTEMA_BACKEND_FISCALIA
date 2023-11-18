package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.CargoRepository;
import et.clicket.api.appClicket.data.PerfilRepository;
import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Perfil;
import et.clicket.api.appClicket.domain.mapper.CargoMapper;
import et.clicket.api.appClicket.domain.mapper.PerfilMapper;
import et.clicket.api.appClicket.domain.service.interfaces.CargoService;
import et.clicket.api.appClicket.domain.service.interfaces.PerfilService;
import et.clicket.api.appClicket.presentation.request.dto.CargoDto;
import et.clicket.api.appClicket.presentation.request.dto.PerfilDto;
import et.clicket.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    perfilRepository.save(perfilFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
