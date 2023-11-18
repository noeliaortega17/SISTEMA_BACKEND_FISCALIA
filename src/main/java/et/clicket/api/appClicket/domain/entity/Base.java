package et.clicket.api.appClicket.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Base {

  public boolean activo = true;

  @Column(updatable = false)
  @CreationTimestamp
  public LocalDateTime fecha_creacion;

  @UpdateTimestamp
  public LocalDateTime fecha_modificacion;

  public LocalDateTime fecha_eliminacion;

  public int usuario_creacion;

  public int usuario_modificaion;

  public int usuario_eliminacion;

}
