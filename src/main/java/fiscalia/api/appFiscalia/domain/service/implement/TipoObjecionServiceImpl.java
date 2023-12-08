package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.TipoObjecionRepository;
import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import fiscalia.api.appFiscalia.domain.mapper.TipoObjecionMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.TipoObjecionService;
import fiscalia.api.appFiscalia.presentation.request.dto.TipoObjecionDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TipoObjecionServiceImpl implements TipoObjecionService {

  private final TipoObjecionRepository tipoObjecionRepository;
  private final TipoObjecionMapper tipoObjecionMapper;


  @Override
  public List<TipoObjecion> getAll() {
    return tipoObjecionRepository.findAllByActivo(true);
  }

  @Override
  public TipoObjecion getById(Integer id) {
    TipoObjecion tipoObjecion = tipoObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoObjecion", id));
    return tipoObjecion;
  }

  @Override
  public TipoObjecion create(TipoObjecionDto tipoObjecionDto) {
    TipoObjecion tipoObjecion = tipoObjecionMapper.fromDto(tipoObjecionDto, null);
    return tipoObjecionRepository.save(tipoObjecion);
  }

  @Override
  public TipoObjecion update(Integer id, TipoObjecionDto tipoObjecionDto) {
    TipoObjecion tipoObjecionFound = tipoObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoObjecion", id));
    TipoObjecion tipoObjecion = tipoObjecionMapper.fromDto(tipoObjecionDto, tipoObjecionFound);
    return tipoObjecionRepository.save(tipoObjecion);
  }

  @Override
  public void delete(Integer id) {
    TipoObjecion tipoObjecionFound = tipoObjecionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TipoObjecion", id));
    tipoObjecionFound.setActivo(false);
    tipoObjecionFound.setFecha_eliminacion(LocalDateTime.now());
    tipoObjecionRepository.save(tipoObjecionFound);

  }

}
