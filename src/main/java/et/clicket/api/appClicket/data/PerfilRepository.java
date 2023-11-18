package et.clicket.api.appClicket.data;

import et.clicket.api.appClicket.domain.entity.Cargo;
import et.clicket.api.appClicket.domain.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    List<Perfil> findAllByActivo(Boolean activo);

}