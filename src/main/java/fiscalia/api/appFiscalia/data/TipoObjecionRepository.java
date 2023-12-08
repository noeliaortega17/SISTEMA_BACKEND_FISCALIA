package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.TipoObjecion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoObjecionRepository extends JpaRepository<TipoObjecion, Integer> {
    List<TipoObjecion> findAllByActivo(Boolean activo);

}