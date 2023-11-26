package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Perfil;
import fiscalia.api.appFiscalia.domain.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    List<Unidad> findAllByActivo(Boolean activo);

}