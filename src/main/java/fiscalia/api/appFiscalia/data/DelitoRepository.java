package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Delito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelitoRepository extends JpaRepository<Delito, Integer> {
    List<Delito> findAllByActivo(Boolean activo);
}