package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.domain.entity.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {
    List<UsuarioPerfil> findAllByActivo(Boolean activo);


    @Query(value = """
      SELECT *
      FROM usuario_perfil
      where usuario = ?1
      """, nativeQuery = true)
    List<UsuarioPerfil> findAllByUsuario(Integer idUsuario);

}