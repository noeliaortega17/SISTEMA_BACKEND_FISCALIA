package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Desarchivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesarchivoRepository extends JpaRepository<Desarchivo, Integer> {
    List<Desarchivo> findAllByActivo(Boolean activo);
}