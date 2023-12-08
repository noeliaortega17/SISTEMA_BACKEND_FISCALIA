package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.DelitoRepository;
import fiscalia.api.appFiscalia.data.TipoDelitoRepository;
import fiscalia.api.appFiscalia.domain.entity.Delito;
import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import fiscalia.api.appFiscalia.domain.mapper.DelitoMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.DelitoService;
import fiscalia.api.appFiscalia.presentation.request.dto.DelitoDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DelitoServiceImpl implements DelitoService {

  private final DelitoRepository delitoRepository;
  private final TipoDelitoRepository tipoDelitoRepository;
  private final DelitoMapper delitoMapper;

  @Override
  public List<Delito> getAll() {
    return delitoRepository.findAllByActivo(true);
  }

  @Override
  public Delito getById(Integer id) {
    Delito delito = delitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delito", id));
    return delito;
  }

  @Override
  public Delito create(DelitoDto delitoDto) {
    TipoDelito tipoDelitoFound = tipoDelitoRepository.findById(delitoDto.getIdTipoDelito().getId()).orElseThrow(() -> new EntityNotFoundException("Instructivo para Delito", delitoDto.getIdTipoDelito().getId()));
    delitoDto.setIdTipoDelito(tipoDelitoFound);
    Delito delito = delitoMapper.fromDto(delitoDto, null);
    return delitoRepository.save(delito);
  }

  @Override
  public Delito update(Integer id, DelitoDto delitoDto) {
    TipoDelito tipoDelitoFound = tipoDelitoRepository.findById(delitoDto.getIdTipoDelito().getId()).orElseThrow(() -> new EntityNotFoundException("Tipo Delito para Delito", delitoDto.getIdTipoDelito().getId()));
    delitoDto.setIdTipoDelito(tipoDelitoFound);
    Delito delitoFound = delitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delito", id));
    Delito delito = delitoMapper.fromDto(delitoDto, delitoFound);
    return delitoRepository.save(delito);
  }

  @Override
  public void delete(Integer id) {
    Delito delitoFound = delitoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delito", id));
    delitoFound.setActivo(false);
    delitoFound.setFecha_eliminacion(LocalDateTime.now());
    delitoRepository.save(delitoFound);
  }

}
