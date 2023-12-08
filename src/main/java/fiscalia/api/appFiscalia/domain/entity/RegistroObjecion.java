package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "registroObjecion")

public class RegistroObjecion extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private Integer numeroResolucion;

  private Integer cud;
  @ManyToOne
  @JoinColumn(name = "tipoObjecion_id")
  private TipoObjecion idTipoObjecion;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private Funcionario idFuncionario;
}


