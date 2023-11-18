package et.clicket.api.appClicket.presentation.response.pojo;

import et.clicket.api.common.Pojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@Getter
@Setter
@NoArgsConstructor
public class EnterprisePojo {
  private String code;
  private String name;
  private String domain;
  private String urlLogo;

  public EnterprisePojo(String code, String name, String domain, String urlLogo ) {
    this.code = code;
    this.name = name;
    this.domain = domain;
    this.urlLogo = urlLogo;
  }
}

