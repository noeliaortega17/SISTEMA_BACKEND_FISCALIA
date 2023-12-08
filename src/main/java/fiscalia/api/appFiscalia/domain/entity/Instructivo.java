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
@Table(name = "instructivo")

public class Instructivo extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column()
  private Integer cite;

  private String descripcion;

  private Boolean fiscaliaGeneral;

  public LocalDateTime fechaInstructivo;

  @Column(columnDefinition = "TEXT")
  private String pdf;


}


