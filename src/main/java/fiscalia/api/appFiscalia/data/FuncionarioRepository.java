package fiscalia.api.appFiscalia.data;

import fiscalia.api.appFiscalia.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findAllByActivo(Boolean activo);
}