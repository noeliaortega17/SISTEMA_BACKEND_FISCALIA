package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    List<Cargo> findAllByActivo(Boolean activo);
}