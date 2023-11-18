package et.clicket.api.appClicket.domain.service.implement;


import et.clicket.api.appClicket.data.FuncionarioRepository;
import et.clicket.api.appClicket.data.PerfilRepository;
import et.clicket.api.appClicket.data.UsuarioPerfilRepository;
import et.clicket.api.appClicket.data.UsuarioRepository;
import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Perfil;
import et.clicket.api.appClicket.domain.entity.Usuario;
import et.clicket.api.appClicket.domain.entity.UsuarioPerfil;
import et.clicket.api.appClicket.domain.mapper.FuncionarioMapper;
import et.clicket.api.appClicket.domain.mapper.UsuarioPerfilMapper;
import et.clicket.api.appClicket.domain.service.interfaces.FuncionarioService;
import et.clicket.api.appClicket.domain.service.interfaces.UsuarioPerfilService;
import et.clicket.api.appClicket.presentation.request.dto.FuncionarioDto;
import et.clicket.api.appClicket.presentation.request.dto.UsuarioPerfilDto;
import et.clicket.api.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    UsuarioPerfil usuarioPerfilFound = usuarioPerfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", id));
    UsuarioPerfil usuarioPerfil = usuarioPerfilMapper.fromDto(usuarioPerfilDto, usuarioPerfilFound);
    return usuarioPerfilRepository.save(usuarioPerfil);
  }

  @Override
  public void delete(Integer id) {
    UsuarioPerfil usuarioPerfilFound = usuarioPerfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UsuarioPerfil", id));
    usuarioPerfilFound.setActivo(false);
    usuarioPerfilRepository.save(usuarioPerfilFound);
    // Persona persona = personaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Enterprise", id));
    // personaRepository.delete(persona);
  }

}
