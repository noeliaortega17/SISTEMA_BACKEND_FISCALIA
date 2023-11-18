package et.clicket.api.appClicket.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

  private Boolean fiscalia_general;

  @CreationTimestamp
  public LocalDateTime fecha_instructivo;

}


