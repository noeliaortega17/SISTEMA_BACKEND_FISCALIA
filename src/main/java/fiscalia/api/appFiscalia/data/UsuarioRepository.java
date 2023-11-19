package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByActivo(Boolean activo);
}