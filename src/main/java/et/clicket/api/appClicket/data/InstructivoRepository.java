package et.clicket.api.appClicket.data;

import et.clicket.api.appClicket.domain.entity.Instructivo;
import et.clicket.api.appClicket.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructivoRepository extends JpaRepository<Instructivo, Integer> {

}