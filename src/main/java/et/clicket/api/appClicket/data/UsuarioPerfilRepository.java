package et.clicket.api.appClicket.data;

import et.clicket.api.appClicket.domain.entity.Funcionario;
import et.clicket.api.appClicket.domain.entity.Persona;
import et.clicket.api.appClicket.domain.entity.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {
    List<UsuarioPerfil> findAllByActivo(Boolean activo);

}