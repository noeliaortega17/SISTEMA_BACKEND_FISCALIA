package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
List<Persona> findAllByActivo(Boolean activo);
}