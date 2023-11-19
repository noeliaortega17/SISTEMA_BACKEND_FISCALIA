package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Instructivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructivoRepository extends JpaRepository<Instructivo, Integer> {

}