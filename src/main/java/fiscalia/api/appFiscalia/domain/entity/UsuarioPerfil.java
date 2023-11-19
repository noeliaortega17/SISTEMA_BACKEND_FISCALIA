package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "usuarioPerfil")

public class UsuarioPerfil extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario idUsuario;

  @ManyToOne
  @JoinColumn(name = "perfil_id")
  private Perfil idPerfil;

}


