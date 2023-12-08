package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.TipoDelito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TipoDelitoRepository extends JpaRepository<TipoDelito, Integer>{
    List<TipoDelito> findAllByActivo(Boolean activo);
}
