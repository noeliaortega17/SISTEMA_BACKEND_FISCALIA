package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.PerfilRepository;
import fiscalia.api.appFiscalia.data.UnidadRepository;
import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import fiscalia.api.appFiscalia.domain.mapper.PerfilMapper;
import fiscalia.api.appFiscalia.domain.mapper.UnidadMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.PerfilService;
import fiscalia.api.appFiscalia.domain.service.interfaces.UnidadService;
import fiscalia.api.appFiscalia.presentation.request.dto.PerfilDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UnidadDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UnidadServiceImpl implements UnidadService {

  private final UnidadRepository unidadRepository;
  private final UnidadMapper unidadMapper;

  @Override
  public List<Unidad> getAll() {
    return unidadRepository.findAllByActivo(true);
  }

  @Override
  public Unidad getById(Integer id) {
    Unidad unidad = unidadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unidad", id));
    return unidad;
  }

  @Override
  public Unidad create(UnidadDto unidadDto) {
    Unidad unidad = unidadMapper.fromDto(unidadDto, null);
    return unidadRepository.save(unidad);
  }

  @Override
  public Unidad update(Integer id, UnidadDto unidadDto) {
    Unidad unidadFound = unidadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unidad", id));
    Unidad unidad = unidadMapper.fromDto(unidadDto, unidadFound);
    return unidadRepository.save(unidad);
  }

  @Override
  public void delete(Integer id) {
    Unidad unidadFound = unidadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Unidad", id));
    unidadFound.setActivo(false);
    unidadFound.setFecha_eliminacion(LocalDateTime.now());
    unidadRepository.save(unidadFound);
  }

}
