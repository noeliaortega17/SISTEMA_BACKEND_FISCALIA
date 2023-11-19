package fiscalia.api.appFiscalia.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "persona")

public class Persona extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 10 ,nullable = false)
  private String nombre;

  @Column(length = 50)
  private String apellidoPat;

  @Column(length = 50)
  private String apellidoMat;

  @Column(length = 15)
  private String ci;

  @Column()
  private Integer celular ;



}


