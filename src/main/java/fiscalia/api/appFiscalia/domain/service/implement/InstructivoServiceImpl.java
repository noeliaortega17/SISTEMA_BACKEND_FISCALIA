package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.InstructivoRepository;
import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import fiscalia.api.appFiscalia.domain.mapper.InstructivoMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.InstructivoService;
import fiscalia.api.appFiscalia.presentation.request.dto.InstructivoDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructivoServiceImpl implements InstructivoService{

  private final InstructivoRepository instructivoRepository;
  private final InstructivoMapper instructivoMapper;

  @Override
  public List<Instructivo> getAll() {
    return instructivoRepository.findAll();
  }

  @Override
  public Instructivo getById(Integer id) {
    Instructivo instructivo = instructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Instructivo", id));
    return instructivo;
  }

  @Override
  public Instructivo create(InstructivoDto instructivoDto) {
    Instructivo instructivo = instructivoMapper.fromDto(instructivoDto, null);
    return instructivoRepository.save(instructivo);
  }

  @Override
  public Instructivo update(Integer id, InstructivoDto instructivoDto) {
    Instructivo instructivoFound = instructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Instructivo", id));
    Instructivo instructivo = instructivoMapper.fromDto(instructivoDto, instructivoFound);
    return instructivoRepository.save(instructivo);
  }

  @Override
  public void delete(Integer id) {
    Instructivo instructivoFound = instructivoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Instructivo", id));
    instructivoFound.setActivo(false);
    instructivoRepository.save(instructivoFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
