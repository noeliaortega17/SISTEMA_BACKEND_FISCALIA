package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.RegistroObjecion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroObjecionRepository extends JpaRepository<RegistroObjecion, Integer> {
    List<RegistroObjecion> findAllByActivo(Boolean activo);
}