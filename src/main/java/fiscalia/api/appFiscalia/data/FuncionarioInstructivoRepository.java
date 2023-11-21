package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import fiscalia.api.appFiscalia.domain.entity.FuncionarioInstructivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioInstructivoRepository extends JpaRepository<FuncionarioInstructivo, Integer> {
    List<FuncionarioInstructivo> findAllByActivo(Boolean activo);
}