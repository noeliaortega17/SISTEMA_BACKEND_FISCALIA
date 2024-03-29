package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.FuncionarioRepository;
import fiscalia.api.appFiscalia.data.PerfilRepository;
import fiscalia.api.appFiscalia.data.UsuarioPerfilRepository;
import fiscalia.api.appFiscalia.data.UsuarioRepository;
import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import fiscalia.api.appFiscalia.domain.mapper.UsuarioMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.UsuarioService;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioDto;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginRequest;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginResponse;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final FuncionarioRepository funcionarioRepository;

  private final PerfilRepository perfilRepository;
  private final UsuarioPerfilRepository usuarioPerfilRepository;
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
    Funcionario funcionarioFound = funcionarioRepository.findById(usuarioDto.getIdFuncionario().getId()).orElseThrow(() -> new EntityNotFoundException("Funcionario para usuario", usuarioDto.getIdFuncionario().getId()));
    usuarioDto.setIdFuncionario(funcionarioFound);
    Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    Usuario usuario = usuarioMapper.fromDto(usuarioDto, usuarioFound);
    return usuarioRepository.save(usuario);
  }

  @Override
  public void delete(Integer id) {
    Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario", id));
    usuarioFound.setActivo(false);
    usuarioFound.setFecha_eliminacion(LocalDateTime.now());
    usuarioRepository.save(usuarioFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

  public UsuarioLoginResponse login(UsuarioLoginRequest usuarioLogin) {
    List<Usuario> usuarios = usuarioRepository.login(usuarioLogin.getUser(), usuarioLogin.getPassword());
    Usuario usuario = new Usuario();
    UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
    Perfil perfil = new Perfil();
    if ( usuarios != null && usuarios.size() > 0 ){
      usuario = usuarios.get(0);
      List<UsuarioPerfil> usuarioPerfiles = usuarioPerfilRepository.findAllByUsuario(usuario.getId());
      if ( usuarioPerfiles != null && usuarioPerfiles.size() > 0 ){
        usuarioPerfil = usuarioPerfiles.get(0);
      }
      perfil = perfilRepository.findById(usuarioPerfil.getIdPerfil().getId()).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", 0 ));
    }
    UsuarioLoginResponse userResponse = new UsuarioLoginResponse();
    userResponse.setUsuario(usuario);
    userResponse.setPerfil(perfil);
    return  userResponse;
  }
}
