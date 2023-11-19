package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.FuncionarioRepository;
import fiscalia.api.appFiscalia.data.UsuarioRepository;
import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.domain.mapper.UsuarioMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.UsuarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final FuncionarioRepository funcionarioRepository;
  private final UsuarioMapper usuarioMapper;

  @Override
  public List<Usuario> getAll() {
    return usuarioRepository.findAllByActivo(true);
  }

  @Override
  public Usuario getById(Integer id) {
    Usuario funcionario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    return funcionario;
  }

  @Override
  public Usuario create(UsuarioDto usuarioDto) {
    Funcionario funcionarioFound = funcionarioRepository.findById(usuarioDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para usuario", usuarioDto.getIdFuncionario().getId()));
    usuarioDto.setIdFuncionario(funcionarioFound);
    Usuario usuario = usuarioMapper.fromDto(usuarioDto, null);
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario update(Integer id, UsuarioDto usuarioDto) {
    Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    Usuario usuario = usuarioMapper.fromDto(usuarioDto, usuarioFound);
    return usuarioRepository.save(usuario);
  }

  @Override
  public void delete(Integer id) {
    Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    usuarioFound.setActivo(false);
    usuarioRepository.save(usuarioFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
