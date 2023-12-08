package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.TipoDelitoRepository;
import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import fiscalia.api.appFiscalia.domain.mapper.TipoDelitoMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.TipoDelitoService;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoDelitoDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TipoDelitoServiceImpl implements TipoDelitoService {

  private final TipoDelitoRepository tipoDelitoRepository;
  private final TipoDelitoMapper tipoDelitoMapper;

  @Override
  public List<TipoDelito> getAll() {
    return tipoDelitoRepository.findAllByActivo(true);
  }

  @Override
  public TipoDelito getById(Integer id) {
    TipoDelito tipoDelito = tipoDelitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoDelito", id));
    return tipoDelito;
  }

  @Override
  public TipoDelito create(TipoDelitoDto tipoDelitoDto) {
    TipoDelito tipoDelito = tipoDelitoMapper.fromDto(tipoDelitoDto, null);
    return tipoDelitoRepository.save(tipoDelito);
  }

  @Override
  public TipoDelito update(Integer id, TipoDelitoDto tipoDelitoDto) {
    TipoDelito tipoDelitoFound = tipoDelitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoDelito", id));
    TipoDelito tipoDelito = tipoDelitoMapper.fromDto(tipoDelitoDto, tipoDelitoFound);
    return tipoDelitoRepository.save(tipoDelito);
  }

  @Override
  public void delete(Integer id) {
    TipoDelito tipoDelitoFound = tipoDelitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoDelito", id));
    tipoDelitoFound.setActivo(false);
    tipoDelitoFound.setFecha_eliminacion(LocalDateTime.now());
    tipoDelitoRepository.save(tipoDelitoFound);

  }

}
