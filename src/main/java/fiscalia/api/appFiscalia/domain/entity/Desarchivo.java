package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "desarchivo")

public class Desarchivo extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer cud;

  private String motivo;

  public LocalDateTime fechaDesarchivo;

  public LocalDateTime fechaAsignacion;

  public LocalDateTime fechaRecepcion;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private Funcionario idFuncionario;

  @ManyToOne
  @JoinColumn(name = "delito_id")
  private Delito idDelito;

}


