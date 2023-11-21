package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "funcionarioInstructivo")

public class FuncionarioInstructivo extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private Funcionario idFuncionario;

  @ManyToOne
  @JoinColumn(name = "instructivo_id")
  private Instructivo idInstructivo;

}


