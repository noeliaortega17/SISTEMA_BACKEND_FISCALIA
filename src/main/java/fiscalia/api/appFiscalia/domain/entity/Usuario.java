package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuario")

public class Usuario extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private String usuario ;
  @Column(length = 10 ,nullable = false)
  private String contrasena;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private Funcionario idFuncionario;

}


