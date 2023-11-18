package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.FuncionarioRepository;
import et.clicket.api.appClicket.data.InstructivoRepository;
import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Instructivo;
import et.clicket.api.appClicket.domain.mapper.FuncionarioMapper;
import et.clicket.api.appClicket.domain.mapper.InstructivoMapper;
import et.clicket.api.appClicket.domain.service.interfaces.FuncionarioService;
import et.clicket.api.appClicket.domain.service.interfaces.InstructivoService;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.InstructivoDto;
import et.clicket.api.exception.EntityNotFoundException;
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
