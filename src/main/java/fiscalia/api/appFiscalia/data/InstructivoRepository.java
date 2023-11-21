package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import fiscalia.api.appFiscalia.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructivoRepository extends JpaRepository<Instructivo, Integer> {
    List<Instructivo> findAllByActivo(Boolean activo);
}