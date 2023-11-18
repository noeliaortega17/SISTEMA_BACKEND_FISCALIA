package et.clicket.api.appClicket.data;

import et.clicket.api.appClicket.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
List<Persona> findAllByActivo(Boolean activo);
}