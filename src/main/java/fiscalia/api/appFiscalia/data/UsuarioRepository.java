package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Usuario;
import fiscalia.api.appFiscalia.presentation.request.dto.UsuarioLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByActivo(Boolean activo);

    @Query(value = """
      SELECT *
      FROM usuario
      where usuario = ?1 AND contrasena = ?2
      """, nativeQuery = true)
    List<Usuario> login(String user, String password);
}