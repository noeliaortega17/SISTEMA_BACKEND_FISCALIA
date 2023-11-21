package fiscalia.api.appFiscalia.domain.service.implement;


import fiscalia.api.appFiscalia.data.PerfilRepository;
import fiscalia.api.appFiscalia.data.UsuarioPerfilRepository;
import fiscalia.api.appFiscalia.data.UsuarioRepository;
import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import fiscalia.api.appFiscalia.domain.mapper.UsuarioPerfilMapper;
import fiscalia.api.appFiscalia.domain.service.interfaces.UsuarioPerfilService;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioPerfilDto;
import fiscalia.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

  private final UsuarioPerfilRepository usuarioPerfilRepository;
  private final UsuarioRepository usuarioRepository;
  private final PerfilRepository perfilRepository;
  private final UsuarioPerfilMapper usuarioPerfilMapper;

  @Override
  public List<UsuarioPerfil> getAll() {
    return usuarioPerfilRepository.findAllByActivo(true);
  }

  @Override
  public UsuarioPerfil getById(Integer id) {
    UsuarioPerfil usuarioPerfil = usuarioPerfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", id));
    return usuarioPerfil;
  }

  @Override
  public UsuarioPerfil create(UsuarioPerfilDto usuarioPerfilDto) {
    Usuario usuarioFound = usuarioRepository.findById(usuarioPerfilDto.getIdUsuario().getId()).orElseThrow(() -> new EntityNotFoundException("Usuario para usuarioPerfil", usuarioPerfilDto.getIdUsuario().getId()));
    usuarioPerfilDto.setIdUsuario(usuarioFound);
    Perfil perfilFound = perfilRepository.findById(usuarioPerfilDto.getIdPerfil().getId()).orElseThrow(() -> new EntityNotFoundException("Perfil para usuarioPerfil", usuarioPerfilDto.getIdPerfil().getId()));
    usuarioPerfilDto.setIdPerfil(perfilFound);
    UsuarioPerfil usuarioPerfil = usuarioPerfilMapper.fromDto(usuarioPerfilDto, null);
    return usuarioPerfilRepository.save(usuarioPerfil);
  }

  @Override
  public UsuarioPerfil update(Integer id, UsuarioPerfilDto usuarioPerfilDto) {
    Usuario usuarioFound = usuarioRepository.findById(usuarioPerfilDto.getIdUsuario().getId()).orElseThrow(() -> new EntityNotFoundException("Usuario para usuarioPerfil", usuarioPerfilDto.getIdUsuario().getId()));
    usuarioPerfilDto.setIdUsuario(usuarioFound);
    Perfil perfilFound = perfilRepository.findById(usuarioPerfilDto.getIdPerfil().getId()).orElseThrow(() -> new EntityNotFoundException("Perfil para usuarioPerfil", usuarioPerfilDto.getIdPerfil().getId()));
    usuarioPerfilDto.setIdPerfil(perfilFound);
    UsuarioPerfil usuarioPerfilFound = usuarioPerfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", id));
    UsuarioPerfil usuarioPerfil = usuarioPerfilMapper.fromDto(usuarioPerfilDto, usuarioPerfilFound);
    return usuarioPerfilRepository.save(usuarioPerfil);
  }

  @Override
  public void delete(Integer id) {
    UsuarioPerfil usuarioPerfilFound = usuarioPerfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", id));
    usuarioPerfilFound.setActivo(false);
    usuarioPerfilFound.setFecha_eliminacion(LocalDateTime.now());
    usuarioPerfilRepository.save(usuarioPerfilFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
